package io.itcast.cfc.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.itcast.cfc.constant.ClientExceptionConstant;
import io.itcast.cfc.dto.in.*;
import io.itcast.cfc.dto.out.CustomerGetProfileOutDTO;
import io.itcast.cfc.dto.out.CustomerLoginOutDTO;
import io.itcast.cfc.exception.ClientException;
import io.itcast.cfc.model.Customer;
import io.itcast.cfc.service.CustomerService;
import io.itcast.cfc.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.HashMap;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private SecureRandom secureRandom;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private HashMap<String, String> emailPwdResetCodeMap = new HashMap();

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterInDTO customerRegisterInDTO){
        Integer customerId = customerService.register(customerRegisterInDTO);
        return customerId;
    }

    @GetMapping("/login")
    public CustomerLoginOutDTO login(CustomerLoginInDTO customerLoginInDTO) throws ClientException {
        Customer customer = customerService.getByUsername(customerLoginInDTO.getUsername());
        if(customer == null) {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRMSG);
        }
        BCrypt.Result result = BCrypt.verifyer().verify(customerLoginInDTO.getPassword().toCharArray(), customer.getEncryptedPassword());
        if(result.verified){
            CustomerLoginOutDTO customerLoginOutDTO = jwtUtil.issueToken(customer);
            return customerLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE,ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }
    }

    @GetMapping("/getProfile")
    public CustomerGetProfileOutDTO getProfile(@RequestAttribute Integer customerId){
        Customer customer = customerService.getById(customerId);
        CustomerGetProfileOutDTO customerGetProfileOutDTO = new CustomerGetProfileOutDTO();
        customerGetProfileOutDTO.setUsername(customer.getUsername());
        customerGetProfileOutDTO.setRealName(customer.getRealName());
        customerGetProfileOutDTO.setMobile(customer.getMobile());
        customerGetProfileOutDTO.setMobileVerified(customer.getMobileVerified());
        customerGetProfileOutDTO.setEmail(customer.getEmail());
        customerGetProfileOutDTO.setEmailVerified(customer.getEmailVerified());
        return customerGetProfileOutDTO;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody CustomerUpdateProfileInDTO customerUpdateProfileInDTO,
                              @RequestAttribute Integer customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setRealName(customerUpdateProfileInDTO.getRealName());
        customer.setMobile(customerUpdateProfileInDTO.getMobile());
        customer.setEmail(customerUpdateProfileInDTO.getEmail());
        customerService.update(customer);
    }

    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdInDTO customerChangePwdInDTO,
                          @RequestAttribute Integer customerId) throws ClientException {
        Customer customer = customerService.getById(customerId);
        BCrypt.Result result = BCrypt.verifyer().verify(customerChangePwdInDTO.getOriginPwd().toCharArray(), customer.getEncryptedPassword());
        if(result.verified){
            String bcryptPassword = BCrypt.withDefaults().hashToString(12, customerChangePwdInDTO.getNewPwd().toCharArray());
            customer.setEncryptedPassword(bcryptPassword);
            customerService.update(customer);
        }else{
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE,ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }
    }

    @GetMapping("/getPwdResetCode")
    public void getPwdResetCode(@RequestParam String email) throws ClientException {
        Customer customer = customerService.getByEmail(email);
        if (customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE,ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }
        byte[] bytes = secureRandom.generateSeed(3);
        String hexBinary = DatatypeConverter.printHexBinary(bytes);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setTo(email);
        mailMessage.setSubject("重置密码");
        mailMessage.setText(hexBinary);
        mailSender.send(mailMessage);
        emailPwdResetCodeMap.put(email,hexBinary);
    }

    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody CustomerResetPwdInDTO customerResetPwdInDTO) throws ClientException {
        String email = customerResetPwdInDTO.getEmail();
        if (email == null) {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_EMAIL_NONE_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_EMAIL_NONE_ERRMSG);
        }
        String innerResetCode = emailPwdResetCodeMap.get(email);
        if (innerResetCode == null) {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_INNER_RESETCODE_NONE_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_INNER_RESETCODE_NONE_ERRMSG);
        }
        String outerResetCode = customerResetPwdInDTO.getResetCode();
        if (outerResetCode == null) {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_OUTER_RESETCODE_NONE_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_OUTER_RESETCODE_NONE_ERRMSG);
        }
        if (!outerResetCode.equalsIgnoreCase(innerResetCode)){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_RESETCODE_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_RESETCODE_INVALID_ERRMSG);
        }
        Customer customer = customerService.getByEmail(email);
        if (customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_EMAIL_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_EMAIL_NOT_EXIST_ERRMSG);
        }

        String newPwd = customerResetPwdInDTO.getNewPwd();
        if (newPwd == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_NEWPWD_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_NEWPWD_NOT_EXIST_ERRMSG);
        }
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, newPwd.toCharArray());
        customer.setEncryptedPassword(bcryptHashString);
        customerService.update(customer);

        emailPwdResetCodeMap.remove(email);
    }
}

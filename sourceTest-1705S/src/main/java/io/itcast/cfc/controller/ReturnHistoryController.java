package io.itcast.cfc.controller;

import io.itcast.cfc.constant.ClientExceptionConstant;
import io.itcast.cfc.dto.out.ReturnHistoryListOutDTO;
import io.itcast.cfc.dto.in.ReturnHistoryCreateInDTO;
import io.itcast.cfc.exception.ClientException;
import io.itcast.cfc.model.Return;
import io.itcast.cfc.model.ReturnHistory;
import io.itcast.cfc.service.ReturnHistoryService;
import io.itcast.cfc.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/returnHistory")
@CrossOrigin
public class ReturnHistoryController {

    @Autowired
    private ReturnHistoryService returnHistoryService;

    @Autowired
    private ReturnService returnService;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @GetMapping("/getListByReturnId")
    public List<ReturnHistoryListOutDTO> getListByReturnId(@RequestParam Integer returnId){
        List<ReturnHistory> returnHistoryList = returnHistoryService.getListByReturnId(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS = returnHistoryList.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setReturnHistoryId(returnHistory.getReturnId());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setCustomerNotified(returnHistory.getCustomerNotified());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());
        return returnHistoryListOutDTOS;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        ReturnHistory returnHistory = new ReturnHistory();
        returnHistory.setReturnId(returnHistoryCreateInDTO.getReturnId());
        returnHistory.setComment(returnHistoryCreateInDTO.getComment());
        returnHistory.setTime(new Date());
        returnHistory.setReturnStatus(returnHistoryCreateInDTO.getReturnStatus());
        returnHistory.setCustomerNotified(returnHistoryCreateInDTO.getCustomerNotified());

        Integer returnHistoryId = returnHistoryService.create(returnHistory);
        //发送邮件通知客户
        if(returnHistoryCreateInDTO.getCustomerNotified()==true){
            Return returnOne = returnService.getById(returnHistoryCreateInDTO.getReturnId());
            String email = returnOne.getEmail();
            if(!email.equals(null)){

                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom(fromEmail);
                mailMessage.setTo(email);
                mailMessage.setSubject("物品申请处理");
                mailMessage.setText(returnHistoryCreateInDTO.getComment());
                mailSender.send(mailMessage);
            }else{
                try {
                    throw new ClientException(ClientExceptionConstant.CUSTOMER_EMAIL_NOT_EXIST_ERRCODE,ClientExceptionConstant.CUSTOMER_EMAIL_NOT_EXIST_ERRMSG);
                } catch (ClientException e) {
                    e.printStackTrace();
                }
            }

        }
        return returnHistoryId;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer returnHistoryId){

    }
}

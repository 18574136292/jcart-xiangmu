package io.itcast.cfc.controller;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.out.ReturnListOutDTO;
import io.itcast.cfc.dto.out.ReturnShowOutDTO;
import io.itcast.cfc.dto.in.ReturnSearchInDTO;
import io.itcast.cfc.dto.in.ReturnUpdateActionInDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import io.itcast.cfc.model.Return;
import io.itcast.cfc.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @GetMapping("/pageSearch")
    public PageOutDTO<ReturnListOutDTO> pageSearch(ReturnSearchInDTO returnSearchInDTO,
                                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<Return> returnPage = returnService.pageSearch(pageNum,returnSearchInDTO);
        List<ReturnListOutDTO> returnListOutDTOS = returnPage.stream().map(returnOne -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(returnOne.getReturnId());
            returnListOutDTO.setOrderId(returnOne.getOrderId());
            returnListOutDTO.setCustomerId(returnOne.getCustomerId());
            returnListOutDTO.setCustomerName(returnOne.getCustomerName());
            returnListOutDTO.setProductCode(returnOne.getProductCode());
            returnListOutDTO.setProductName(returnOne.getProductName());
            returnListOutDTO.setCustomerName(returnOne.getCustomerName());
            returnListOutDTO.setStatus(returnOne.getStatus());
            returnListOutDTO.setCreateTimestamp(returnOne.getCreateTime().getTime());
            returnListOutDTO.setUpdateTimestamp(returnOne.getUpdateTime().getTime());
            return returnListOutDTO;
        }).collect(Collectors.toList());
        PageOutDTO<ReturnListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(returnPage.getTotal());
        pageOutDTO.setPageNum(returnPage.getPageNum());
        pageOutDTO.setPageSize(returnPage.getPageSize());
        pageOutDTO.setList(returnListOutDTOS);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        Return returnOne = returnService.getById(returnId);
        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();
        returnShowOutDTO.setReturnId(returnOne.getReturnId());
        returnShowOutDTO.setOrderId(returnOne.getOrderId());
        returnShowOutDTO.setOrderTimestamp(returnOne.getOrderTime().getTime());
        returnShowOutDTO.setCustomerId(returnOne.getCustomerId());
        returnShowOutDTO.setCustomerName(returnOne.getCustomerName());
        returnShowOutDTO.setMobile(returnOne.getMobile());
        returnShowOutDTO.setEmail(returnOne.getEmail());
        returnShowOutDTO.setStatus(returnOne.getStatus());
        returnShowOutDTO.setAction(returnOne.getAction());
        returnShowOutDTO.setProductCode(returnOne.getProductCode());
        returnShowOutDTO.setProductName(returnOne.getProductName());
        returnShowOutDTO.setQuantity(returnOne.getQuantity());
        returnShowOutDTO.setReason(returnOne.getReason());
        returnShowOutDTO.setOpened(returnOne.getOpened());
        returnShowOutDTO.setComment(returnOne.getComment());
        returnShowOutDTO.setCreateTimestamp(returnOne.getCreateTime().getTime());
        returnShowOutDTO.setUpdateTimestamp(returnOne.getUpdateTime().getTime());
        return returnShowOutDTO;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){
        Return returnOne = new Return();
        returnOne.setReturnId(returnUpdateActionInDTO.getReturnId());
        returnOne.setAction(returnUpdateActionInDTO.getAction());
        returnOne.setUpdateTime(new Date());
        returnService.update(returnOne);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer returnId){

    }
}

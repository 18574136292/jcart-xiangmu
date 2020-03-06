package io.itcast.cfc.controller;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.ReturnApplyInDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import io.itcast.cfc.dto.out.ReturnHistoryListOutDTO;
import io.itcast.cfc.dto.out.ReturnListOutDTO;
import io.itcast.cfc.dto.out.ReturnShowOutDTO;
import io.itcast.cfc.enumeration.ReturnStatus;
import io.itcast.cfc.model.Return;
import io.itcast.cfc.model.ReturnHistory;
import io.itcast.cfc.service.ReturnHistoryService;
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

    @Autowired
    private ReturnHistoryService returnHistoryService;

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO,
                         @RequestAttribute Integer customerId){
        Return returnOne = new Return();
        returnOne.setOrderId(returnApplyInDTO.getOrderId());
        returnOne.setOrderTime(new Date(returnApplyInDTO.getOrderTimestamp()));
        returnOne.setCustomerId(customerId);
        returnOne.setCustomerName(returnApplyInDTO.getCustomerName());
        returnOne.setMobile(returnApplyInDTO.getMobile());
        returnOne.setEmail(returnApplyInDTO.getEmail());
        returnOne.setStatus((byte) ReturnStatus.ToProcess.ordinal());
        returnOne.setProductCode(returnApplyInDTO.getProductCode());
        returnOne.setProductName(returnApplyInDTO.getProductName());
        returnOne.setQuantity(returnApplyInDTO.getQuantity());
        returnOne.setReason(returnApplyInDTO.getReason());
        returnOne.setOpened(returnApplyInDTO.getOpened());
        returnOne.setComment(returnApplyInDTO.getComment());
        returnOne.setCreateTime(new Date());
        returnOne.setUpdateTime(new Date());
        Integer returnId = returnService.create(returnOne);
        return returnId;
    }

    @GetMapping("/getList")
    public PageOutDTO<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<Return> returnList = returnService.getByCustomerId(customerId,pageNum);
        List<ReturnListOutDTO> returnListOutDTOS = returnList.stream().map(returns -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(returns.getReturnId());
            returnListOutDTO.setOrderId(returns.getOrderId());
            returnListOutDTO.setCustomerId(returns.getCustomerId());
            returnListOutDTO.setCustomerName(returns.getCustomerName());
            returnListOutDTO.setStatus(returns.getStatus());
            returnListOutDTO.setCreateTimestamp(returns.getCreateTime().getTime());
            return returnListOutDTO;
        }).collect(Collectors.toList());
        PageOutDTO<ReturnListOutDTO> returnListOutDTOPageOutDTO = new PageOutDTO<>();
        returnListOutDTOPageOutDTO.setTotal(returnList.getTotal());
        returnListOutDTOPageOutDTO.setPageSize(returnList.getPageSize());
        returnListOutDTOPageOutDTO.setPageNum(returnList.getPageNum());
        returnListOutDTOPageOutDTO.setList(returnListOutDTOS);
        return returnListOutDTOPageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        Return returnOne = returnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();
        returnShowOutDTO.setReturnId(returnOne.getReturnId());
        returnShowOutDTO.setOrderId(returnOne.getOrderId());
        returnShowOutDTO.setOrderTimestamp(returnOne.getOrderTime().getTime());
        returnShowOutDTO.setCustomerName(returnOne.getCustomerName());
        returnShowOutDTO.setMobile(returnOne.getMobile());
        returnShowOutDTO.setEmail(returnOne.getEmail());
        returnShowOutDTO.setStatus(returnOne.getStatus());
        returnShowOutDTO.setAction(returnOne.getAction());
        returnShowOutDTO.setProductCode(returnOne.getProductCode());
        returnShowOutDTO.setProductName(returnOne.getProductName());
        returnShowOutDTO.setQuantity(returnOne.getQuantity());
        returnShowOutDTO.setReason(returnOne.getReason());
        returnShowOutDTO.setComment(returnOne.getComment());
        returnShowOutDTO.setOpened(returnOne.getOpened());
        returnShowOutDTO.setCreateTimestamp(returnOne.getCreateTime().getTime());
        returnShowOutDTO.setUpdateTimestamp(returnOne.getUpdateTime().getTime());

        List<ReturnHistory> returnHistoryList = returnHistoryService.getHistoryByReturnId(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS = returnHistoryList.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());
        returnShowOutDTO.setReturnHistories(returnHistoryListOutDTOS);
        return returnShowOutDTO;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }

}
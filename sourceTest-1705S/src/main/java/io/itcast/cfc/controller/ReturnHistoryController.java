package io.itcast.cfc.controller;

import io.itcast.cfc.dto.out.ReturnHistoryListOutDTO;
import io.itcast.cfc.dto.in.ReturnHistoryCreateInDTO;
import io.itcast.cfc.model.ReturnHistory;
import io.itcast.cfc.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/returnHistory")
@CrossOrigin
public class ReturnHistoryController {

    @Autowired
    private ReturnHistoryService returnHistoryService;
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
        return returnHistoryId;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer returnHistoryId){

    }
}

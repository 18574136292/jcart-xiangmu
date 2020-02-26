package io.itcast.cfc.cfc.controller;

import io.itcast.cfc.cfc.dto.out.ReturnHistoryListOutDTO;
import io.itcast.cfc.cfc.dto.in.ReturnHistoryCreateInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returnHistory")
public class ReturnHistoryController {

    @GetMapping("/getListByReturnId")
    public List<ReturnHistoryListOutDTO> getListByReturnId(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        return null;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer returnHistoryId){

    }
}

package io.itcast.cfc.controller;

import io.itcast.cfc.dto.in.ReturnHistoryCreateInDTO;
import io.itcast.cfc.dto.out.ReturnHistoryListOutDTO;
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

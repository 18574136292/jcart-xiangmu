package io.itcast.cfc.controller;

import io.itcast.cfc.dto.in.ReturnSearchInDTO;
import io.itcast.cfc.dto.in.ReturnUpdateActionInDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import io.itcast.cfc.dto.out.ReturnListOutDTO;
import io.itcast.cfc.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @GetMapping("/pageSearch")
    public PageOutDTO<ReturnListOutDTO> pageSearch(ReturnSearchInDTO returnSearchInDTO, @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){

    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer returnId){

    }
}

package io.itcast.cfc.controller;

import io.itcast.cfc.cfc.dto.in.*;
import io.itcast.cfc.dto.in.*;
import io.itcast.cfc.dto.out.AdministratorGetProfileOutDTO;
import io.itcast.cfc.dto.out.AdministratorListOutDTO;
import io.itcast.cfc.dto.out.AdministratorShowOutDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @GetMapping("/loginIn")
    public String login(AdministratorLoginInDTO administratorLoginInDTO){

        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfileOutDTO(@RequestParam(required = false)Integer administratorId){
        return null;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

    }

    @GetMapping("/getPasswordResetCode")
    public String getPasswordResetCode(@RequestParam String email){
        return null;
    }

    @PostMapping("/resetPassword")
    public void resetPassword(@RequestBody AdministratorResetPwdInDTO administratorResetPwdInDTO){

    }

    @GetMapping("/getList")
    public PageOutDTO<AdministratorListOutDTO> getList(@RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(@RequestParam Integer administratorId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AdministratorCreateInDTO administratorCreateInDTO){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateInDTO administratorUpdateInDTO){

    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer administratorId){

    }

    @PostMapping("/deleteAny")
    public void deleteAny(@RequestBody List<Integer> administratorIds){

    }
}

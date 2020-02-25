package io.itcast.cfc.controller;

import io.itcast.cfc.model.Administrator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdministratorController {


    @GetMapping("loginIn")
    public String login(Administrator administrator){
        return null;
    }

    @GetMapping("/getOneAdministrator")
    public Administrator getOneAdministrator(Integer administratorId){
        return null;
    }

    @PostMapping("/updateAdministrator")
    public void updateAdministrator(@RequestBody Administrator administrator){

    }

    @PostMapping("/deleteAdministrator")
    public void deleteAdministrator(Integer administratorId){

    }
}

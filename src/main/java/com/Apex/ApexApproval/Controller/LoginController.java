package com.Apex.ApexApproval.Controller;

import com.Apex.ApexApproval.Repository.UserTableRepository;
import com.Apex.ApexApproval.Service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    UserTableService userTableService;
    @GetMapping("/check")
    public Boolean verifyEmail(@RequestParam String userEmail){
        if(userEmail.endsWith("@bitsathy.ac.in")){
            return userTableService.contains(userEmail);
        }
        return false;
    }
}

package com.Apex.ApexApproval.Controller;

import com.Apex.ApexApproval.Model.Management;
import com.Apex.ApexApproval.Service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Component
@RequestMapping("/management")
@CrossOrigin
public class ManagementController {
    @Autowired
    ManagementService managementService;
    @GetMapping("/show")
    public ResponseEntity<List<Management>> showAll(){

        return new ResponseEntity<>(managementService.showAll(),HttpStatus.OK);
    }
}

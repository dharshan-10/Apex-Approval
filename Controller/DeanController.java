package com.Apex.ApexApproval.Controller;

import com.Apex.ApexApproval.Model.Dean;
import com.Apex.ApexApproval.Model.Principal;
import com.Apex.ApexApproval.Service.DeanService;
import com.Apex.ApexApproval.Service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@Controller
@RequestMapping("/dean")
public class DeanController {
    @Autowired
    DeanService deanService;
    @PostMapping("/add")
    public ResponseEntity<Void> addRequest(@RequestBody Dean dean){
        deanService.addRequest(dean);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}

package com.Apex.ApexApproval.Controller;

import com.Apex.ApexApproval.Model.Principal;
import com.Apex.ApexApproval.Service.PrincipalService;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@Controller
@RequestMapping("/principal")
@CrossOrigin
public class PrincipalController {
    @Autowired
    PrincipalService principalService;
    @PostMapping("/add")
    public ResponseEntity<Void> addRequest(@RequestBody Principal principal){
        principalService.addRequest(principal);
        return new ResponseEntity<>( HttpStatus.OK);
    }


}

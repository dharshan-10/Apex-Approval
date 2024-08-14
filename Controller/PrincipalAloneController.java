package com.Apex.ApexApproval.Controller;

import com.Apex.ApexApproval.Model.Principal;
import com.Apex.ApexApproval.Service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@Component
@RequestMapping("/principalalone")
@CrossOrigin
public class PrincipalAloneController {
    @Autowired
    PrincipalService principalService;

    @GetMapping("/show")
    public ResponseEntity<List<Principal>> showAll(){
        return new ResponseEntity<>(principalService.showAll(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestParam int id, @RequestParam int approvalStatus){
        System.out.println("Receieved the update request form server-Inside the Controller");
        principalService.update(id,approvalStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

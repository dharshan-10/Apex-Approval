package com.Apex.ApexApproval.Controller;

import com.Apex.ApexApproval.Model.Dean;
import com.Apex.ApexApproval.Service.DeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Component
@RequestMapping("/deanalone")
@CrossOrigin
public class DeanAloneController {
    @Autowired
    DeanService deanService;
    @GetMapping("/show")
    public ResponseEntity<List<Dean>> showAll(){
        return new ResponseEntity<>(deanService.showAll(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestParam int id, @RequestParam Boolean approvalStatus){
        deanService.update(id,approvalStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

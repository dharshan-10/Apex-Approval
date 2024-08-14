package com.Apex.ApexApproval.Controller;

import com.Apex.ApexApproval.Model.MTeam;
import com.Apex.ApexApproval.Model.Principal;
import com.Apex.ApexApproval.Service.MTeamService;
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
@RequestMapping("/mteam")
public class MTeamController {
    @Autowired
    MTeamService mTeamService;
    @PostMapping("/add")
    public ResponseEntity<Void> addRequest(@RequestBody MTeam mTeam){
        mTeamService.addRequest(mTeam);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}

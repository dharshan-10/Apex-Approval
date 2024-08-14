package com.Apex.ApexApproval.Controller;

import com.Apex.ApexApproval.Model.MTeam;
import com.Apex.ApexApproval.Service.MTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@Controller
@RequestMapping("/mteamalone")
@CrossOrigin
public class MTeamAloneController {
    @Autowired
    MTeamService mTeamService;
    @GetMapping("/show")
    public ResponseEntity<List<MTeam>> showAll(){
        return new ResponseEntity<>(mTeamService.showAll(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestParam int id, @RequestParam Boolean approvalStatus){
        mTeamService.update(id,approvalStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.ApexApproval.Controller;

import com.example.ApexApproval.Model.MTeam;
import com.example.ApexApproval.Model.User;
import com.example.ApexApproval.Model.UserTable;
import com.example.ApexApproval.Service.MTeamService;
import com.example.ApexApproval.Service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@Controller
@RequestMapping("/mteam")
@CrossOrigin
public class MTeamController {
    @Autowired
    MTeamService mTeamService;
    @GetMapping("/show")
    public ResponseEntity<List<MTeam>> showAll(){
        return new ResponseEntity<>(mTeamService.showAll(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestParam int id, @RequestParam int approvalStatus){
        mTeamService.update(id,approvalStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Autowired
    UserTableService userTableService;
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserTable user) {
        userTableService.addUser(user);  // Create the user
        return new ResponseEntity<>( HttpStatus.CREATED);  // Return the created user
    }
}

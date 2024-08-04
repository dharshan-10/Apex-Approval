package com.example.Apex.controller;

import com.example.Apex.entity.Approval_Form;
import com.example.Apex.entity.HOD;
import com.example.Apex.entity.MaintenanceRequest;
import com.example.Apex.entity.User;
import com.example.Apex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/user")
@EnableWebMvc
public class UserController implements WebMvcConfigurer {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }

    @PostMapping("/Maintenance/insert")
    public ResponseEntity<String> createMaintenanceRequest(@RequestBody MaintenanceRequest maintenanceRequest) {
        String submitTo = maintenanceRequest.getSubmitTo();

        if (submitTo == null) {
            return new ResponseEntity<>("submitTo cannot be null", HttpStatus.BAD_REQUEST);
        }

        switch (submitTo) {
            case "HOD":
                userService.addToHod(maintenanceRequest);
                break;
            case "MTeam":
                userService.addToMTeam(maintenanceRequest);
                // Handle MTeam case if needed
                break;
            case "Principal":
                // Handle Principal case if needed
                break;
            default:
                return new ResponseEntity<>("Invalid submitTo value: " + submitTo, HttpStatus.BAD_REQUEST);
        }

        System.out.println("Received maintenance request: " + maintenanceRequest);
        return new ResponseEntity<>("Received the Maintenance Request Successfully", HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> createApprovalRequest(@RequestBody Approval_Form approvalRequest) {
        // Process the approval request
        // Save the data to the database or perform any other necessary operations
        System.out.println("Received approval request:");
        System.out.println("Application type: " + approvalRequest.getApplicationType());
        System.out.println("Application reason: " + approvalRequest.getApplicationReason());
        System.out.println("Application amount: " + approvalRequest.getApplicationAmount());

        // Return a success response
        return new ResponseEntity<>("Approval request submitted successfully", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<Boolean> checkUser(@RequestBody User user) {
        boolean userExists = userService.checkUser(user);
        return ResponseEntity.ok(userExists);
    }
}

package com.example.ApexApproval.Controller;

    import com.example.ApexApproval.Model.User;
    import com.example.ApexApproval.Service.UserService; // Assuming you have a service to handle business logic
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Map;

    @RestController
    @CrossOrigin() // Adjust origins as needed
    @RequestMapping("/dashboard")
    public class UserController {

        @Autowired
        private UserService userService; // Assume UserService handles the business logic

        @GetMapping("/show")
        public List<User> showAll(@RequestParam String username) {
            username=username.substring(0,username.indexOf("@"));
            System.out.println("Got the Request "+username);
            String userTableName = "user_" + username;
            // Fetch users from the service or directly from the repository
            return userService.showAll(userTableName); // Implement this method in UserService
        }
        @PostMapping("/add")
        public ResponseEntity<String> addRequest(@RequestBody User user){
           return userService.add(user);
        }
    }

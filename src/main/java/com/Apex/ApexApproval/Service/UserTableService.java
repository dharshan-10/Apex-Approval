package com.Apex.ApexApproval.Service;

import com.Apex.ApexApproval.Model.User;
import com.Apex.ApexApproval.Model.UserTable;
import com.Apex.ApexApproval.Repository.UserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTableService {
    @Autowired
    UserTableRepository userTableRepository;
    @Autowired
    TableManagementService tableManagementService;
    public void addUser(UserTable user) {
        userTableRepository.save(user);
          tableManagementService.createUserTable(user.getEmail());

    }

    public boolean contains(String userEmail) {

        try {
            return userTableRepository.existsByEmail(userEmail);
        } catch (Exception e) {
            // Log the error
            System.err.println("Error checking email: " + e.getMessage());
            return false; // or handle accordingly
        }
    }
}

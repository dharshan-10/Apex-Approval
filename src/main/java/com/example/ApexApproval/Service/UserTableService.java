package com.example.ApexApproval.Service;

import com.example.ApexApproval.Model.User;
import com.example.ApexApproval.Model.UserTable;
import com.example.ApexApproval.Repository.UserTableRepository;
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
        return userTableRepository.existsByEmail(userEmail);
    }
}

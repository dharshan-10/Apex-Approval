package com.example.Apex.service;

import com.example.Apex.entity.MaintenanceRequest;
import com.example.Apex.entity.User;

public interface UserService {

    void addUser(User user);

    boolean checkUser(User user);

    void addToHod(MaintenanceRequest maintenanceRequest);
    void addToMTeam(MaintenanceRequest maintenanceRequest);
}

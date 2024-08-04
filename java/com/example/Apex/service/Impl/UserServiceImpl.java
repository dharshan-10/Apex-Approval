package com.example.Apex.service.Impl;

import com.example.Apex.entity.MaintenanceRequest;
import com.example.Apex.entity.User;
import com.example.Apex.repository.HODRepository;
import com.example.Apex.repository.MTeamRepository;
import com.example.Apex.repository.UserRepository;
import com.example.Apex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final HODRepository hodRepository;
  private final MTeamRepository mTeamRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, HODRepository hodRepository, MTeamRepository mTeamRepository) {
    this.userRepository = userRepository;
    this.hodRepository = hodRepository;
    this.mTeamRepository = mTeamRepository;
  }

  @Override
  @Transactional
  public void addUser(User user) {
    userRepository.save(user);
  }

  @Override
  @Transactional
  public void addToHod(MaintenanceRequest maintenanceRequest) {
    // Assuming submitTo is a valid type (e.g., "HOD")
    hodRepository.save(maintenanceRequest);
  }

  @Override
  @Transactional
  public void addToMTeam(MaintenanceRequest maintenanceRequest) {
    // Assuming submitTo is a valid type (e.g., "MTeam")
    mTeamRepository.save(maintenanceRequest);
  }

  @Override
  public boolean checkUser(User user) {
    User newUser = userRepository.findByUsername(user.getUsername());
    return newUser != null &&
            newUser.getPassword().equals(user.getPassword()) &&
            newUser.getUsertype().equals(user.getUsertype());
  }
}

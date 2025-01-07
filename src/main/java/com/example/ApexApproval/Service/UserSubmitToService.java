package com.example.ApexApproval.Service;

import com.example.ApexApproval.Model.Dean;
import com.example.ApexApproval.Model.MTeam;
import com.example.ApexApproval.Model.Principal;
import com.example.ApexApproval.Model.User;
import com.example.ApexApproval.Repository.DeanRepository;
import com.example.ApexApproval.Repository.MTeamRepository;
import com.example.ApexApproval.Repository.PrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSubmitToService {
@Autowired
    DeanRepository deanRepository;
@Autowired
    PrincipalRepository principalRepository;
@Autowired
    MTeamRepository mTeamRepository;
    public void add(User user) {
        switch (user.getSubmitTo()){
            case "Principal":
                Principal principal= new Principal(user.getApplicationType(),user.getLocation(),user.getReason(),user.getAmount(),user.getIsApproved(),user.getSubmittedFacultyName(),user.getFacultyId(),user.getName());
                principalRepository.save(principal);
                break;
            case "Dean":
                Dean dean = new Dean(user.getApplicationType(),user.getLocation(),user.getReason(),user.getAmount(),user.getIsApproved(),user.getSubmittedFacultyName(),user.getFacultyId(),user.getName());
                deanRepository.save(dean);
                break;
            case "MTeam":
                MTeam mTeam = new MTeam(user.getApplicationType(),user.getLocation(),user.getReason(),user.getAmount(),user.getIsApproved(),user.getSubmittedFacultyName(),user.getFacultyId(),user.getName());
                mTeamRepository.save(mTeam);
                break;
        }
    }
}

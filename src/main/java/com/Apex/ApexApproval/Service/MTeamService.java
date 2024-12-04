package com.Apex.ApexApproval.Service;

import com.Apex.ApexApproval.Model.Dean;
import com.Apex.ApexApproval.Model.MTeam;
import com.Apex.ApexApproval.Model.Management;
import com.Apex.ApexApproval.Repository.MTeamRepository;
import com.Apex.ApexApproval.Repository.ManagementRepository;
import com.Apex.ApexApproval.Repository.UserTableRepository;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MTeamService {
    @Autowired
    MTeamRepository mTeamRepository;
    @Autowired
    ManagementRepository managementRepository;
    @Autowired
    UserTableRepository userTableRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void addRequest(MTeam mTeam) {
        mTeamRepository.save(mTeam);
    }

    public List<MTeam> showAll() {
        return mTeamRepository.findAll();
    }
    public void update(int id, int approvalStatus) {
        Optional<MTeam> optionalMTeam = mTeamRepository.findById(id);

        if (optionalMTeam.isPresent()) {
            MTeam mTeam = optionalMTeam.get();
            mTeam.setIsApproved(approvalStatus);
            mTeamRepository.save(mTeam);
            if(approvalStatus==1) {
                Management management = new Management(mTeam.getApplicationType(), mTeam.getLocation(),
                        mTeam.getReason(), mTeam.getAmount(), "MTeam",
                        mTeam.getSubmittedFacultyName(), mTeam.getFacultyId());
                managementRepository.save(management);
            }
            String userID = mTeam.getFacultyId();
            String userEmail=userTableRepository.findEmailByFacultyId(userID);
            String prefix=userEmail.substring(0,userEmail.indexOf("@"));
            String tableName = "user_"+prefix ;
            String applicationType=mTeam.getApplicationType();
            String location= mTeam.getLocation();
            String reason= mTeam.getReason();
            long amount= mTeam.getAmount();
            String sql = "UPDATE " + tableName + " SET is_approved = ? WHERE application_type = ? AND location = ? AND amount = ? AND reason = ?";

            // Execute the update query with the actual values
            jdbcTemplate.update(sql, approvalStatus, applicationType, location, amount, reason);
        } else {
            System.out.println("Principal with id " + id + " not found.");
        }
    }
}

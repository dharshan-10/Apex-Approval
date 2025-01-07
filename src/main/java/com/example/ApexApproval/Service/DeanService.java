package com.example.ApexApproval.Service;

import com.example.ApexApproval.Model.Dean;
import com.example.ApexApproval.Model.Management;
import com.example.ApexApproval.Model.Principal;
import com.example.ApexApproval.Repository.DeanRepository;
import com.example.ApexApproval.Repository.ManagementRepository;
import com.example.ApexApproval.Repository.UserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeanService {
@Autowired
    DeanRepository deanRepository;
@Autowired
    ManagementRepository managementRepository;
@Autowired
    UserTableRepository userTableRepository;
@Autowired
    JdbcTemplate jdbcTemplate;
    public void addRequest(Dean dean) {
        deanRepository.save(dean);
    }

    public List<Dean> showAll() {
        return deanRepository.findAll();
    }
    public void update(int id, int approvalStatus) {
        Optional<Dean> optionalDean = deanRepository.findById(id);

        if (optionalDean.isPresent()) {
            Dean dean=optionalDean.get();
            dean.setIsApproved(approvalStatus);
            deanRepository.save(dean);
            if(approvalStatus==1) {
                Management management = new Management(dean.getApplicationType(), dean.getLocation(),
                        dean.getReason(), dean.getAmount(), "Dean",
                        dean.getSubmittedFacultyName(), dean.getFacultyId());
                managementRepository.save(management);
            }
            String UserId=dean.getFacultyId();
            String userEmail=userTableRepository.findEmailByFacultyId(UserId);
            String tableName="user_"+userEmail.substring(0,userEmail.indexOf("@"));
            String sql="UPDATE " + tableName + " SET is_approved = ? WHERE application_type = ? AND location = ? AND amount = ? AND reason = ?";
            jdbcTemplate.update(sql, approvalStatus, dean.getApplicationType(), dean.getLocation(), dean.getAmount(), dean.getReason());
        } else {
            System.out.println("Principal with id " + id + " not found.");
        }
    }
}

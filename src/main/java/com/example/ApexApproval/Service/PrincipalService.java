package com.example.ApexApproval.Service;

import com.example.ApexApproval.Model.Management;
import com.example.ApexApproval.Model.Principal;
import com.example.ApexApproval.Model.UserTable;
import com.example.ApexApproval.Repository.ManagementRepository;
import com.example.ApexApproval.Repository.PrincipalRepository;
import com.example.ApexApproval.Repository.UserRepository;
import com.example.ApexApproval.Repository.UserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrincipalService {
    @Autowired
    PrincipalRepository principalRepository;
    @Autowired
    ManagementRepository managementRepository;



    public List<Principal> showAll() {
        return principalRepository.findAll();
    }

   public void update(int id, int approvalStatus) {
        Optional<Principal> optionalPrincipal = principalRepository.findById(id);
        if (optionalPrincipal.isPresent()) {
           Principal principal = optionalPrincipal.get();
            principal.setIsApproved(approvalStatus);
            principalRepository.save(principal);
            if(approvalStatus==1){

                Management management=new Management(principal.getApplicationType(),principal.getLocation(),
                        principal.getReason(),principal.getAmount(),"Principal",
                        principal.getSubmittedFacultyName(),principal.getFacultyId());
                managementRepository.save(management);
            }

            String userID = principal.getFacultyId();
            String userEmail=userTableRepository.findEmailByFacultyId(userID);
            String prefix=userEmail.substring(0,userEmail.indexOf("@"));
            String tableName = "user_"+prefix ;
            String applicationType=principal.getApplicationType();
            String location= principal.getLocation();
            String reason= principal.getReason();
            String sql = "UPDATE " + tableName + " SET is_approved = ? WHERE application_type = ? AND location = ? AND reason = ?";

            // Execute the update query with the actual values
            jdbcTemplate.update(sql, approvalStatus, applicationType, location, reason);

        } else {
            System.out.println("Principal with id " + id + " not found.");
        }

    }

    @Autowired
    private JdbcTemplate jdbcTemplate;  // Used for dynamic table operations
    @Autowired
    UserTableRepository userTableRepository;


}

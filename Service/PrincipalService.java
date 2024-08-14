package com.Apex.ApexApproval.Service;

import com.Apex.ApexApproval.Model.Management;
import com.Apex.ApexApproval.Model.Principal;
import com.Apex.ApexApproval.Repository.ManagementRepository;
import com.Apex.ApexApproval.Repository.PrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrincipalService {
    @Autowired
    PrincipalRepository principalRepository;
    @Autowired
    ManagementRepository managementRepository;
    public void addRequest(Principal principal) {
      principalRepository.save(principal);
    }

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

                System.out.println("Inside the If-Inside the Service");
                Management management=new Management();
                management.setApplicationType(principal.getApplicationType());
                management.setApprovedBy("Principal");
                management.setAmount(principal.getAmount());
                management.setLocation(principal.getLocation());
                management.setFacultyId(principal.getFacultyId());
                management.setSubmittedFacultyName(principal.getSubmittedFacultyName());
                management.setReason(principal.getReason());
                managementRepository.save(management);
            }
        } else {
            System.out.println("Principal with id " + id + " not found.");
        }

    }

}

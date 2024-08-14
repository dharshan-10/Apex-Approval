package com.Apex.ApexApproval.Service;

import com.Apex.ApexApproval.Model.Dean;
import com.Apex.ApexApproval.Model.Principal;
import com.Apex.ApexApproval.Repository.DeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeanService {
@Autowired
    DeanRepository deanRepository;
    public void addRequest(Dean dean) {
        deanRepository.save(dean);
    }

    public List<Dean> showAll() {
        return deanRepository.findAll();
    }
    public void update(int id, Boolean approvalStatus) {
        Optional<Dean> optionalDean = deanRepository.findById(id);

        if (optionalDean.isPresent()) {
            Dean dean = optionalDean.get();
            dean.setApproved(approvalStatus);
            deanRepository.save(dean);
        } else {
            System.out.println("Principal with id " + id + " not found.");
        }
    }
}

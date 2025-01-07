package com.example.ApexApproval.Service;

import com.example.ApexApproval.Model.Management;
import com.example.ApexApproval.Repository.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {
    @Autowired
    ManagementRepository managementRepository;

    public List<Management> showAll() {
        return managementRepository.findAll();
    }
}

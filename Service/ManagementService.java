package com.Apex.ApexApproval.Service;

import com.Apex.ApexApproval.Model.Management;
import com.Apex.ApexApproval.Repository.ManagementRepository;
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

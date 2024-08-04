package com.example.Apex.repository;

import com.example.Apex.entity.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HODRepository extends JpaRepository<MaintenanceRequest, Long> {
        // No need to declare save method, it's already provided by JpaRepository
        // If you need custom query methods, you can define them here
}

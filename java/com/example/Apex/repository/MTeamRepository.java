package com.example.Apex.repository;

import com.example.Apex.entity.MTeam;
import com.example.Apex.entity.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MTeamRepository extends JpaRepository<MaintenanceRequest,Long> {
}

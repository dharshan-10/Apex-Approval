package com.Apex.ApexApproval.Repository;

import com.Apex.ApexApproval.Model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserTableRepository extends JpaRepository<UserTable, Integer> {
    boolean existsByEmail (String email);

    @Query("SELECT u.email FROM UserTable u WHERE u.facultyId = :facultyId")
    String findEmailByFacultyId(@Param("facultyId") String facultyId);
}

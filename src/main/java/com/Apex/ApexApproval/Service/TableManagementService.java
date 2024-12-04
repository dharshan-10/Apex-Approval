package com.Apex.ApexApproval.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableManagementService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUserTable(String email) {


        // Extract the table name from the email
        String prefix = email.substring(0, email.indexOf("@"));
        String tableName = "User_" + prefix;

        // Define the SQL to create the table
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "application_type VARCHAR(255) NOT NULL, " +
                "location TEXT, " +
                "reason TEXT, " +
                "name VARCHAR(1000), " +
                "submit_to VARCHAR(1000), " +
                "amount VARCHAR(1000), " +
                "is_approved INT" +  // Fixed: added closing parenthesis here
                ")";
// Added closing parenthesis and semicolon
   
        // Execute the SQL statement to create the table
        jdbcTemplate.execute(sql);
    }
}

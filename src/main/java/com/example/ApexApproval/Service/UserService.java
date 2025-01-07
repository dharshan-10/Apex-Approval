package com.example.ApexApproval.Service;

import com.example.ApexApproval.Model.Principal;
import com.example.ApexApproval.Model.User;
import com.example.ApexApproval.Repository.PrincipalRepository;
import com.example.ApexApproval.Repository.UserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Define a list of allowed table names
    private static final List<String> ALLOWED_TABLES = Arrays.asList("users", "user_user1");

    public List<User> showAll(String tableName) {
        System.out.println("Inside the UserService showAll method : "+tableName);
        // Validate the table name
        if (!ALLOWED_TABLES.contains(tableName.toLowerCase())) {
            throw new IllegalArgumentException("Invalid table name: " + tableName);
        }

        // Construct the SQL query dynamically
        String sql = "SELECT * FROM " + tableName;

        // Define a RowMapper to map rows of the result set to User objects
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setSubmitTo(rs.getString("submit_to"));
                user.setName(rs.getString("name"));
                user.setApplicationType(rs.getString("application_type"));
                user.setLocation(rs.getString("location"));
                user.setReason(rs.getString("reason"));
                user.setAmount(rs.getLong("amount"));
                user.setIsApproved(rs.getInt("is_approved"));
                return user;
            }
        };

        // Execute the query and return the results mapped to User objects
        return jdbcTemplate.query(sql, rowMapper);
    }
    @Autowired
    UserTableRepository userTableRepository;
    @Autowired
    UserSubmitToService userSubmitToService;
    @Autowired
    EmailService emailService;
    public ResponseEntity<String> add(User user) {

        String userID = user.getFacultyId();
        System.out.println("The user Id is "+userID);
        String userEmail=userTableRepository.findEmailByFacultyId(userID);
        String prefix=userEmail.substring(0,userEmail.indexOf("@"));
        String tableName = "user_"+prefix ;
        if (userTableRepository.existsByEmail(tableName)) {
            // Email already exists
            return ResponseEntity.badRequest().body("Email already exists.");
        }

        // Construct SQL for inserting into the user-specific table
        String sql = "INSERT INTO " + tableName + " (application_type, location, reason, name, submit_to, amount, is_approved) VALUES (?, ?, ?, ?, ?, ?, ?)";


            emailService.SendEmail(user.getSubmittedFacultyName(),"dharshankkrlb2@gmail.com");



// Execute the SQL statement
        jdbcTemplate.update(sql,
                user.getApplicationType(),
                user.getLocation(),
                user.getReason(),
                user.getName(),
                user.getSubmitTo(),
                user.getAmount(),
                user.getIsApproved());
        userSubmitToService.add(user);
        return ResponseEntity.ok("User added successfully.");
    }
}

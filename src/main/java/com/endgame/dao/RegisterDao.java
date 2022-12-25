package com.endgame.dao;

import com.endgame.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegisterDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int register(Register register) {
        String sql = "insert into endgameusers values(?,?,?,?,?)";
        try {

            int counter = jdbcTemplate.update(sql, register.getFirstname(), register.getLastname(), register.getEmail(), register.getUsername(), register.getPassword());

            return counter;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}

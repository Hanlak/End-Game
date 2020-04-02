package com.endgame.dao;

import com.endgame.model.Register;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegisterDao {
    private JdbcTemplate jdbcTemplate;

    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

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

package com.endgame.dao;

import com.endgame.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDao {


    @Autowired
    private JdbcTemplate template;


    public Login getUserById(String username) {
        String sql = "select * from endgameusers where username=?";
        try {
            return template.queryForObject(sql, new Object[]
                    {username}, new BeanPropertyRowMapper<>(Login.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

}

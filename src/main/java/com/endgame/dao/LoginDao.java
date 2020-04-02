package com.endgame.dao;

import com.endgame.model.DisplayResult;
import com.endgame.model.Login;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LoginDao {


    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {

        this.template = template;
    }

    public Login getUserById(String username) {
        String sql = "select * from endgameusers where username=?";
        try {
            return template.queryForObject(sql, new Object[]
                    {username}, new BeanPropertyRowMapper<>(Login.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public List<DisplayResult> getfreindsList(String user) {
        //parentuser and consumer
        String query = "select consumer,result from consumerresult where parentuser = ?";
        try {
            return template.query(query, new Object[]{user}, new BeanPropertyRowMapper<>(DisplayResult.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}

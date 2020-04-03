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

    public int updatePasswordViaMail(String email, String password) {
        String query = "update endgameusers set password =? where email = ?";
        try {
            return template.update(query, password, email);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatePasswordViaUser(String username, String password) {
        String query = "update endgameusers set password =? where username = ?";
        try {
            return template.update(query, password, username);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateEmailViaUser(String username, String email) {
        String query = "update endgameusers set email =? where username = ?";
        try {
            return template.update(query, email, username);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

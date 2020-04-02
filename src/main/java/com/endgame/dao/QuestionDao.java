package com.endgame.dao;

import com.endgame.model.ConsumerUser;
import com.endgame.model.Question;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuestionDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Question getQuestionByUserAndId(String username, int id) {
        String query = "select * from questions where username = ? and questionid=?";
        try {
            return template.queryForObject(query, new Object[]{username, id}, new BeanPropertyRowMapper<>(Question.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int insertQuestion(Question question) {
        String query = "insert into questions values(?,?,?)";
        try {
            return template.update(query, question.getName(), question.getQuestionId(), question.getAnswer());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateQuestionAns(Question question) {
        String query = "update questions set answer = ? where username =? and questionid=?";
        try {
            return template.update(query, question.getAnswer(), question.getName(), question.getQuestionId());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int insertDefaultScore(ConsumerUser consumerUser) {
        String query = "insert into consumerresult values(?,?,0)";
        try {
            return template.update(query, consumerUser.getParentUser(), consumerUser.getUser());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ConsumerUser getConsumerByParentUser(ConsumerUser user) {
        String query = "select * from consumerresult where parentuser =? and consumer =?";
        try {
            return template.queryForObject(query, new Object[]{user.getParentUser(), user.getUser()}, new BeanPropertyRowMapper<>(ConsumerUser.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Question> getAllQuestionOfUser(String parentuser) {
        String query = "select * from questions where username = ?";
        try {
            return template.query(query, new Object[]{parentuser},
                    new BeanPropertyRowMapper<>(Question.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int updateResult(ConsumerUser consumerUser, int score) {
        String query = "update consumerresult set score = ? where parentuser =? and consumer =?";
        try {
            return template.update(query, score, consumerUser.getParentUser(), consumerUser.getUser());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

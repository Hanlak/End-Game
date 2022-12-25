package com.endgame.configuration;

import com.endgame.dao.LoginDao;
import com.endgame.dao.QuestionDao;
import com.endgame.dao.RegisterDao;
import com.endgame.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class EndGameConfiguration {

    @Bean
    public LoginDao getLoginDao() {
        return new LoginDao();
    }

    @Bean
    public QuestionDao getQuestionDao() {
        return new QuestionDao();
    }

    @Bean
    public RegisterDao getRegisterDao() {
        return new RegisterDao();
    }

    @Bean
    public UserDao getUserDao() {
        return new UserDao();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/endgame");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        /**
         * To CREATE THE TABLE IF NOT EXISTS AT THE STARTUP OF THE APPLICATION
         *
         * <p>the script file schema-sql.sql will execute here
         */
        // SCHEMA INIT
        Resource intischema = new ClassPathResource("schema.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(intischema);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("my.gmail@gmail.com");
        mailSender.setPassword("password");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}

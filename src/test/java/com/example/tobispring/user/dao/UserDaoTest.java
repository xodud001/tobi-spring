package com.example.tobispring.user.dao;

import com.example.tobispring.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private UserDao dao;

    @BeforeEach
    public void setup(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        dao = context.getBean("userDao", UserDao.class);
    }

    @Test
    public void addAndGet() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        User user1 = new User("dud708", "김태영", "pa55word");
        User user2 = new User("adszzz1", "리상민", "pa55word");
        dao.add(user1);
        dao.add(user2);

        assertThat(dao.getCount()).isEqualTo(2);

        User findUser1 = dao.get(user1.getId());
        assertThat(user1.getName()).isEqualTo(findUser1.getName());
        assertThat(user1.getPassword()).isEqualTo(findUser1.getPassword());
        User findUser2 = dao.get(user2.getId());
        assertThat(user2.getName()).isEqualTo(findUser2.getName());
        assertThat(user2.getPassword()).isEqualTo(findUser2.getPassword());
    }

    @Test
    public void count() throws SQLException {
        User user1 = new User("dud708", "김태영", "pa55word");
        User user2 = new User("adszzz1", "이상민", "pa55word");
        User user3 = new User("qudtls351", "김동영", "pa55word");

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);

    }

    @Test
    void getUserFailure() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        assertThrows(EmptyResultDataAccessException.class,
                () -> dao.get("unknown_id"));
    }
}
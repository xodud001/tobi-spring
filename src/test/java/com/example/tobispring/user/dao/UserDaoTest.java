package com.example.tobispring.user.dao;

import com.example.tobispring.user.domain.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            UserDao dao = new DaoFactory().userDao();

            User user = new User();
            user.setId("dud708");
            user.setName("김태영");
            user.setPassword("pa55word");

            dao.add(user);

            System.out.println(user.getId() + " 등록 성공");

            User findUser = dao.get(user.getId());
            System.out.println(findUser.getName());
            System.out.println(findUser.getPassword());

            System.out.println(findUser.getId() + " 조회 성공");
    }
}
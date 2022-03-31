package com.example.tobispring.user.dao;

import com.example.tobispring.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
            UserDao dao = context.getBean("userDao", UserDao.class);

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

            if (!user.getName().equals(findUser.getName())) {
                    System.out.println("테스트 실패 (name)");
            } else if (!user.getPassword().equals(findUser.getPassword())) {
                    System.out.println("테스트 실패 (password)");
            }else{
                    System.out.println("조회 테스트 성공");
            }
    }
}
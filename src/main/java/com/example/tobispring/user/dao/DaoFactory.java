package com.example.tobispring.user.dao;

public class DaoFactory {

    public UserDao userDao(){
        return new UserDao(new DConnectionMaker());
    }
}

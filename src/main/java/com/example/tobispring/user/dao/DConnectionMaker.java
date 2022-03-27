package com.example.tobispring.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/tobi", "root", "root");
    }
}

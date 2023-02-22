package com.exavalu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionManager {


    public static JDBCConnectionManager connectionManager = null;
    public static Connection connection = null;

    public static Connection getConnection() {

        JDBCUtility jdbcUtility = JDBCUtility.getInstanceOfJDBCUtility();

        String user = jdbcUtility.getPropertyValue("user");
        String password = jdbcUtility.getPropertyValue("pass");
        String dbNname = jdbcUtility.getPropertyValue("dbNname");
        String url = jdbcUtility.getPropertyValue("url");

        System.out.println("URL =" + user);
//        log.info("URL =" + url);

        try {

            if (connection == null) {

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        url + dbNname, user, password);

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }

        return connection;
    }

}

package org.example;

import javax.xml.transform.Result;
import java.sql.*;

public final  class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost/lmsdb";
    private static final String login = "root";
    private static final String password = "";

    public static void saveData(String sqlCommand) throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL,login,password );
        Statement statement = connection.createStatement();
        if (statement.execute(sqlCommand)){
            System.out.println("Data inserted successfully");
        }else {
            System.out.println("Something went wrong");
        }
        connection.close();
    }
    public static ResultSet getData(String sqlCommand) throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, login, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCommand);
        return resultSet;
    }

}

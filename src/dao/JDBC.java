/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
    
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;trustServerCertificate=True;"//integratedSecurity=true;" 
            + "databaseName=QUANLYBANHANG";
    private static final String JDBC_USERNAME = "kha";
    private static final String JDBC_PASSWORD = "12041994";
    

    public static Connection connection;

    public JDBC() {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            //ClassNotFoundException |
                    }
    }
    
    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        return JDBC.connection;
    }

    public ResultSet executeQuery(String sqlQuery) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        return preparedStatement.executeQuery();
    }

    public int executeUpdate(String sqlQuery) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        return preparedStatement.executeUpdate();
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
/**
 *
 * @author A715-42G
 */

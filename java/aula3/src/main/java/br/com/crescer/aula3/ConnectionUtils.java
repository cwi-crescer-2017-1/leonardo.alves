/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leonardo.alves
 */
public class ConnectionUtils {
    private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private final static String USER = "java";
    private final static String PASS = "java";
   
    public static final Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

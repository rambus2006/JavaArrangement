//package org.example;
//
//import java.sql.*;
//
//import static jdk.nashorn.internal.objects.Global.println;
//
//public class Main  {
//    public Main() throws SQLException {
//        String dbURL="jdbc:mysql://localhost:3306/java_db";
//        String dbId="root";
//        String dbPassword="111111";
//        int insertCount = 0;
//
//        Connection conn=null;
//        PreparedStatement ps = null;
////        Connection conn = DriverManager.getConnection(dbURL,dbId,dbPassword);
//
//        // Statement statement = conn.createStatement();
//
//        String sql = "INSERT INTO(username,userscore)VALUES(?,?);";
//        ps = conn.prepareStatement(sql);
//
//        ps.setString(1, score.getUsername());
//        ps.setString(2, score.getUserscore());
//        insertCount = ps.executeUpdate();
//
//        conn.close();
//    }
//}
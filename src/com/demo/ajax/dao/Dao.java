package com.demo.ajax.dao;

import com.demo.ajax.pojo.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Dao {

    public int write(String data) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        String sql = null;
        PreparedStatement ps = null;
        int result = -1;

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demos?useSSL=false&serverTimezone=GMT%2B8",
                "learning", "learning");
        sql = "insert into demo01(data) values(?);";
        ps = conn.prepareStatement(sql);
        ps.setString(1, data);
        result = ps.executeUpdate();
        ps.close();
        conn.close();
        return result;
    }

    public String[] read(int begin, int length) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demos?useSSL=false&serverTimezone=GMT%2B8",
                "learning", "learning");
        String sql = "select data from demo01 where id between ? and ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, begin + "");
        ps.setString(2, begin + length - 1 + "");
        ResultSet rs = ps.executeQuery();
        ArrayList<String> arr = new ArrayList<>();
        while (rs.next()) {
            arr.add(rs.getString("data"));
        }
        rs.close();
        ps.close();
        conn.close();
        return arr.toArray(new String[0]);
    }
}

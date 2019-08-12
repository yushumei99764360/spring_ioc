package com.tk.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author TK
 * @date 2019/6/22 11:40
 */
public class TestDb {
    public static void main(String[] args) {
        Connection connection = ConnectionDataBase.getConnection();
        System.out.println(connection);

        try {
            //
            PreparedStatement ps = connection.prepareStatement("select * from userinfo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("用户id:"+rs.getInt(1)+"用户姓名:"+rs.getString(2)+"密码:"+rs.getString(3)+"邮箱:"+rs.getString(4)+"手机号:"+rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.tk.utils;

import com.tk.dto.DataBaseDto;
import lombok.Data;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author TK
 * @date 2019/6/22 11:19
 */
public class ConnectionDataBase {
    public static Connection connection;

    static {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        DataBaseDto database = applicationContext.getBean("database", DataBaseDto.class);

        try {
            Class.forName(database.getDriver());
            connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

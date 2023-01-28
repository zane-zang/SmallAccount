package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zane
 * @date 2023-01-28-10:24
 */
public class DataBaseUtil {
    static final String database = "db/data.db";
    static {
        try {
            Class.forName("org.mysql.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql:%s", database);
        return DriverManager.getConnection(url);
    }
}

package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zane
 * @date 2023-01-28-10:21
 */
public class SQLUtil {
    private static final File SQLFile = new File(DataBaseUtil.database);

    /**
     * 复制数据库文件到指定文件
     * @param filePath 备份文件的路径
     * @throws IOException
     */
    public static void backup(String filePath) throws IOException {
        //获取目标文件对象
        File osfile = new File(filePath);
        //新建字节流
        try (FileInputStream inputstream = new FileInputStream(SQLFile);
             FileOutputStream outputstream = new FileOutputStream(osfile)) {
            byte[] bytes = new byte[(int) SQLFile.length()];
            //读取字节数组
            int result = inputstream.read(bytes);
            //写出字节数组
            outputstream.write(bytes);
            //清理
            outputstream.flush();
        }
    }

    /**
     * 将定文件更新到数据库文件
     * @param filePath
     * @throws IOException
     */

    public static void update(String filePath) throws IOException {
        //获取文件对象
        File newfile = new File(filePath);
        try (FileInputStream inputstream = new FileInputStream(newfile);
             FileOutputStream outputstream = new FileOutputStream(SQLFile)) {
            byte[] bytes = new byte[(int) newfile.length()];
            //读取字节数组
            int result = inputstream.read(bytes);
            //写出字节数组
            outputstream.write(bytes);
            //清理
            outputstream.flush();
        }

    }

    /**
     * 清空数据库，重置自增值
     */
    public static void truncate() {
        try (Connection c = DataBaseUtil.getConnection();
             Statement s = c.createStatement()){
                 s.execute("delete from config;");
                 s.execute("delete from record;");
                 s.execute("delete from category;");
                 s.execute("delete from mysql_sequence;");
        } catch (SQLException e) {
                 e.printStackTrace();
        }

    }
}

package dao;

import entity.Config;
import util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zane
 * @date 2023-01-28-15:31
 */
public class ConfigDAO {
    public void add(Config config) {
        String sql = "insert into config ('key_','value') values (?,?)";
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, config.getKey());
            ps.setString(2, config.getValue());
            ps.execute();
            ResultSet resultset = ps.getGeneratedKeys();
            if(resultset.next()) {
                int id = resultset.getInt(1);
                config.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int update(Config config) {
        String sql = "update config set key_ = ? , value = ? where id = ?";
        int result = 0;
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, config.getKey());
            ps.setString(2, config.getValue());
            ps.setInt(3, config.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(int id) {
        String sql = "delete from config where id = ?";
        int result = 0;
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Config get(int id) {
        Config config =null;
        String sql = "select * from config where id = ?";
        try (Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultset = ps.executeQuery();
            if (resultset.next()) {
                config = new Config(resultset.getInt("id"),
                        resultset.getString("key_"),
                        resultset.getString("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }
    public Config getByKey(String key) {
        Config config = null;
        String sql = "select * from config where key_ = ?";
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, key);
            ResultSet resultset = ps.executeQuery();
            if (resultset.next()) {
                config = new Config(resultset.getInt("id"),
                        resultset.getString("key_"),
                        resultset.getString("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }

    public List<Config> list(int start, int count) {
        String sql = "select * from config order by id desc limit ?,?";
        List<Config> configList = new ArrayList<>();
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet resultset = ps.executeQuery();
            while(resultset.next()) {
                Config config = new Config(resultset.getInt("id"),
                        resultset.getString("key_"),
                        resultset.getString("value"));
                configList.add(config);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return configList;
    }
    public List<Config> list() {
        return list(0, Short.MAX_VALUE);
    }
    public int getTotal() {
        String sql = "select count(*) from config";
        try(Connection c = DataBaseUtil.getConnection();
            Statement s = c.createStatement()) {
            ResultSet resultset = s.executeQuery(sql);
            if(resultset.next()) {
                return resultset.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

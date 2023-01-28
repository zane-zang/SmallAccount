package dao;

import entity.Category;
import util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zane
 * @date 2023-01-28-14:41
 * DAO类-Category, 对category表进行增删改查的操作
 */
public class CategoryDAO {
    public void add(Category category) {
        String sql = "insert into category ('name') values (?)";
        try (Connection c = DataBaseUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, category.getName());
            ps.execute();
            ResultSet resultset = ps.getGeneratedKeys();
            if (resultset.next()) {
                int id = resultset.getInt(1);
                category.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int update(Category category) {
        String sql = "update category set name = ? where id = ?";
        int result = 0;
        try (Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,category.getName());
            ps.setInt(2, category.getId());
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(int id) {
        String sql = "delete from category where id = ?";
        int result = 0;
        try (Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Category get(int id) {
        Category category = null;
        String sql = "select * from category where id = ?";
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultset = ps.executeQuery();
            if (resultset.next()) {
                category = new Category(resultset.getInt("id"),
                                        resultset.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
    public Category getByKey(String key) {
        Category category = null;
        String sql = "select * from category where key_ = ?";
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, key);
            ResultSet resultset = ps.executeQuery();
            if(resultset.next()) {
                category = new Category(resultset.getInt("id"),
                        resultset.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public List<Category> list(int start, int count) {
        String sql = "select * from category order by id desc limit ?,?";
        List<Category> categoryList = new ArrayList<>();
        try (Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet resultset = ps.executeQuery();
            while (resultset.next()) {
                Category category = new Category(resultset.getInt("id"),
                                                resultset.getString("name"));
                categoryList.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
    public List<Category> list() {
        return list(0, Short.MAX_VALUE);
    }

    public int getTotal() {
        String sql = "select count(*) from category";
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

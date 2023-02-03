package dao;

import entity.Record;
import util.DataBaseUtil;
import util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zane
 * @date 2023-01-28-15:31
 */
public class RecordDAO {
    public void add(Record record) {
        String sql = "insert into record ('spend', 'categoryId', 'comment', 'date') values (?,?,?,?)";
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, record.getSpend());
            ps.setInt(2, record.getCategoryId());
            ps.setString(3, record.getComment());
            ps.setDate(4, DateUtil.util2sql(record.getDate()));
            ps.execute();

            ResultSet resultset = ps.getGeneratedKeys();
            if (resultset.next()) {
                int id = resultset.getInt(1);
                record.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int update(Record record) {
        String sql = "update record set 'spend' = ?, 'categoryId' = ?, 'comment' = ?, 'date' = ? where id = ?";
        int result = 0;
        try(Connection c= DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, record.getSpend());
            ps.setInt(2, record.getCategoryId());
            ps.setString(3, record.getComment());
            ps.setDate(4, DateUtil.util2sql(record.getDate()));
            ps.setInt(5, record.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(int id) {
        String sql = "delete from record where id = ?";
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

    public Record get(int id) {
        Record record = null;
        String sql = "select * from record where id = ?";
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultset = ps.executeQuery();
            if (resultset.next()) {
                record = new Record(resultset.getInt("id"),
                        resultset.getInt("spend"),
                        resultset.getInt("categoryId"),
                        resultset.getString("comment"),
                        resultset.getDate("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;

    }
    public List<Record> list(int start, int count) {
        String sql = "select * from record order by id desc limit ?,?";
        List<Record> recordList = new ArrayList<>();
        try (Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet resultset = ps.executeQuery();
            while (resultset.next()) {
                Record record = new Record(resultset.getInt("id"),
                        resultset.getInt("spend"),
                        resultset.getInt("categoryId"),
                        resultset.getString("comment"),
                        resultset.getDate("date"));
                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    public List<Record> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Record> list(int categoryId) {
        String sql = "select * from record where 'categoryId' = ?";
        List<Record> recordList = new ArrayList<>();
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, categoryId);
            ResultSet resultset = ps.executeQuery();
            while (resultset.next()) {
                Record record = new Record(resultset.getInt("id"),
                        resultset.getInt("spend"),
                        resultset.getInt("categoryId"),
                        resultset.getString("comment"),
                        resultset.getDate("date"));
                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    public List<Record> list(Date date) {
        String sql = "select * from record where 'date' = ?";
        List<Record> recordList = new ArrayList<>();
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, DateUtil.util2sql(date));
            ResultSet resultset = ps.executeQuery();
            while (resultset.next()) {
                Record record = new Record(resultset.getInt("id"),
                        resultset.getInt("spend"),
                        resultset.getInt("categoryId"),
                        resultset.getString("comment"),
                        resultset.getDate("date"));
                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }
    public List<Record> todayList() {
        return list(new Date());
    }

    public List<Record> list(Date start, Date end) {
        String sql = "select * from record where 'date' >= ? and 'date' <= ? ";
        List<Record> recordList = new ArrayList<>();
        try(Connection c = DataBaseUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, DateUtil.util2sql(start));
            ps.setDate(2, DateUtil.util2sql(end));
            ResultSet resultset = ps.executeQuery();
            while(resultset.next()) {
                Record record = new Record(resultset.getInt("id"),
                        resultset.getInt("spend"),
                        resultset.getInt("categoryId"),
                        resultset.getString("comment"),
                        resultset.getDate("date"));
                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    public List<Record> monthList() {
        return list(DateUtil.monthBegin(), DateUtil.monthEnd());
    }
    public int getTotal() {
        String  sql = "select count(*) from record";
        try(Connection c = DataBaseUtil.getConnection();
            Statement s = c.createStatement()) {
            ResultSet resultset = s.executeQuery(sql);
            if (resultset.next()) {
                return resultset.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}


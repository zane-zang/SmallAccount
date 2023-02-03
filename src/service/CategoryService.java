package service;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.List;

/**
 * @author zane
 * @date 2023-01-28-14:40
 */
public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();
    private RecordDAO recordDAO = new RecordDAO();

    public List<Category> list() {
        List<Category> categoryList = categoryDAO.list();
        for (Category c : categoryList) {
            List<Record> recordList = recordDAO.list(c.getId());
            c.setRecordNumber(recordList.size());
        }
        //lambda表达式实现comparator接口
        categoryList.sort((c1, c2) -> c2.getRecordNumber() - c1.getRecordNumber());
        return categoryList;
    }

    public void add(String name) {
        Category c = new Category();
        c.setName(name);
        categoryDAO.add(c);
    }

    public void update(int id, String name) {
        Category c = new Category();
        c.setId(id);
        c.setName(name);
        categoryDAO.update(c);
    }

    public void delete(int id) {
        categoryDAO.delete(id);
    }
}

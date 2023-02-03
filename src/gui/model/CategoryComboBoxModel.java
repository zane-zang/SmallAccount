package gui.model;

import entity.Category;
import service.CategoryService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

/**
 * @author zane
 * @date 2023-01-30-14:04
 */
public class CategoryComboBoxModel implements ComboBoxModel<Category> {
    //从service层获取数据
    public List<Category> categoryList = new CategoryService().list();
    public Category category;

    public CategoryComboBoxModel() {
        if(!categoryList.isEmpty()) {
            category = categoryList.get(0);
        }
    }
    //将选中的对象存到模型
    @Override
    public void setSelectedItem(Object anItem) {
        category = (Category) anItem;

    }

    @Override
    public Object getSelectedItem() {
        return category;
    }

    @Override
    public int getSize() {
        return categoryList.size();
    }

    @Override
    public Category getElementAt(int index) {
        return categoryList.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}

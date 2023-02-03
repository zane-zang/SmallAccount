package gui.model;

import entity.Category;
import service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

/**
 * @author zane
 * @date 2023-01-30-14:34
 * CategoryPanel的Table数据模型，实现了TableModel接口
 */
public class CategoryTableModel implements TableModel {
    //列
    private String[] columnNames = new String[]{"分类名称", "消费次数"};

    //行
    public List<Category> categoryList = new CategoryService().list();

    @Override
    public int getRowCount() {
        return categoryList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return categoryList.get(rowIndex).getName();
        }else if (columnIndex == 1) {
            return categoryList.get(rowIndex).getRecordNumber();
        } else {
            return null;
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}

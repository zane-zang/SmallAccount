package gui.model;

import entity.Record;
import gui.panel.MonthPickerPanel;
import service.RecordService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

/**
 * @author zane
 * @date 2023-01-30-14:41
 * HistoryListPanel的Table的数据模型，实现了TableModel接口
 */
public class RecordTableModel implements TableModel {
    private String[] columnNames = new String[]{"ID", "花费", "分类", "备注", "日期"};
    public List<Record> recordList = new RecordService().listMonth(MonthPickerPanel.instance.date);
    @Override
    public int getRowCount() {
        return recordList.size();
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
        if (columnIndex == 1) {
            return
        }
        return null;
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

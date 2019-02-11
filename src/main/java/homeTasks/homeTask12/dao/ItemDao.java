package homeTasks.homeTask12.dao;

import homeTasks.homeTask12.entity.Items;

import java.util.List;

public interface ItemDao {
    public static final String SQL_FIND_ALL = "select * from " + Items.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Items.ID_COLUMN + " = ?";
    public static final String SQL_INSERT = "insert into " + Items.TABLE_NAME + " (" + Items.NAME_COLUMN + ", " + Items.WAREHOUSE_ID_COLUMN + ") values (?, ?)";
    public static final String SQL_UPDATE = "update " + Items.TABLE_NAME + " set " + Items.NAME_COLUMN + " where " + Items.ID_COLUMN + " = ?";
    public static final String SQL_DELETE = "delete from " + Items.TABLE_NAME + " where " + Items.ID_COLUMN + " = ?";

    public List<Items> findAll();
    public Items findById(Long id);
    public void insert(Items item);
    public void update(Items item);
    public void delete(Items item);
}

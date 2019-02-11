package homeTasks.homeTask12.dao;

import homeTasks.homeTask12.entity.Warehouses;

import java.util.List;

public interface WarehouseDao {
    public static final String SQL_FIND_ALL = "select * from " + Warehouses.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Warehouses.ID_COLUMN + " = ?";
    public static final String SQL_INSERT = "insert into " + Warehouses.TABLE_NAME + " (" + Warehouses.ADDRESS_COLUMN + ") values (?)";
    public static final String SQL_UPDATE = "update " + Warehouses.TABLE_NAME + " set " + Warehouses.ADDRESS_COLUMN +" = ? where " + Warehouses.ID_COLUMN + " = ?";
    public static final String SQL_DELETE = "delete from " + Warehouses.TABLE_NAME + " where " + Warehouses.ID_COLUMN + " = ?";

    public List<Warehouses> findAll();
    public Warehouses findById(Long id);
    public void insert(Warehouses warehouse);
    public void update(Warehouses warehouse);
    public void delete(Warehouses warehouse);
}

package homeTasks.homeTask12.dao.impl;

import homeTasks.homeTask12.dao.WarehouseDao;
import homeTasks.homeTask12.entity.Warehouses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDaoImpl implements WarehouseDao
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseDaoImpl.class);

    @Override
    public List<Warehouses> findAll() {
        List<Warehouses> result = new ArrayList<>();
        try (Connection connection = ConnectionMySql.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Warehouses warehouse = new Warehouses();
                warehouse.setId(rs.getLong("id"));
                warehouse.setAddress(rs.getString("address"));
                result.add(warehouse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Warehouses findById(Long id) {
        Warehouses warehouse = null;
        try (Connection connection = ConnectionMySql.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                warehouse = new Warehouses();
                warehouse.setId(rs.getLong("id"));
                warehouse.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return warehouse;
    }

    @Override
    public void insert(Warehouses warehouse) {
        try (Connection connection = ConnectionMySql.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, warehouse.getAddress());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                warehouse.setId(generatedkeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Warehouses warehouse) {

    }

    @Override
    public void delete(Warehouses warehouse) {

    }
}

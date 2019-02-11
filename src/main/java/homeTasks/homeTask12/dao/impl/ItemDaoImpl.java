package homeTasks.homeTask12.dao.impl;

import homeTasks.homeTask12.dao.ItemDao;
import homeTasks.homeTask12.entity.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDaoImpl.class);

    @Override
    public List<Items> findAll() {
        List<Items> result = new ArrayList<>();
        try (Connection connection = ConnectionMySql.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Items item = new Items();
                item.setId(rs.getLong(Items.ID_COLUMN));
                item.setName(rs.getString(Items.NAME_COLUMN));
                result.add(item);
            }
            LOGGER.info("Items retrieved successfully");
        } catch (SQLException e) {
            LOGGER.error("Error while retrieving items: {}", e);
        }
        return result;
    }

    @Override
    public Items findById(Long id) {
        Items item = null;

        try (Connection connection = ConnectionMySql.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)){
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                item = new Items();
                item.setId(rs.getLong(Items.ID_COLUMN));
                item.setName(rs.getString(Items.NAME_COLUMN));
                item.setWarehouse_id(rs.getLong(Items.WAREHOUSE_ID_COLUMN));
            }
            LOGGER.info("Item found successfully");
        } catch (SQLException e) {
            LOGGER.error("Error while looking for an item by id: {}", e);
        }
        return item;
    }

    @Override
    public void insert(Items item) {
        try (Connection connection = ConnectionMySql.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, item.getName());
            statement.setLong(2, item.getWarehouse_id());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getLong(1));
            }

        } catch (SQLException e) {
            LOGGER.error("Error while inserting a new item: {}", e);
        }
    }

    @Override
    public void update(Items item) {

    }

    @Override
    public void delete(Items item) {

    }
}

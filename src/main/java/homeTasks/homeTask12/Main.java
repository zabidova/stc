package homeTasks.homeTask12;

import homeTasks.homeTask12.dao.WarehouseDao;
import homeTasks.homeTask12.dao.impl.WarehouseDaoImpl;
import homeTasks.homeTask12.entity.Warehouses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        testWarehouseCRUD();
        testItemCRUD();
    }

    private static void testWarehouseCRUD() {
        WarehouseDao warehouseDao = new WarehouseDaoImpl();

        // Создать тестовый объект
        Warehouses testWarehouse = new Warehouses();
        String testData = "test address";
        testWarehouse.setAddress(testData);

        // Сохранить тестовый объект в базе данных
        warehouseDao.insert(testWarehouse);

        // Вытащить тестовый объект из базы данных
        Warehouses warehouseFromDb = warehouseDao.findById(testWarehouse.getId());
        LOGGER.info("Found {} by id {}", warehouseFromDb, testWarehouse.getId());
    }

    private static void testItemCRUD() {

    }
}

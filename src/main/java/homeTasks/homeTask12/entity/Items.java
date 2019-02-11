package homeTasks.homeTask12.entity;

import java.util.HashSet;
import java.util.Set;

public class Items {
    public static final String TABLE_NAME = "items";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String WAREHOUSE_ID_COLUMN = "warehouse_id";

    private Long id;
    private String name;
    private Long warehouse_id;
    private Set<Providers> providers = new HashSet<Providers>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Set<Providers> getProviders() {
        return providers;
    }

    public void setProviders(Set<Providers> providers) {
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

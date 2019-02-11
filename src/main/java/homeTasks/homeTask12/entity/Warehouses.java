package homeTasks.homeTask12.entity;

import java.util.HashSet;
import java.util.Set;

public class Warehouses {
    public static final String TABLE_NAME = "warehouses";
    public static final String ID_COLUMN = "id";
    public static final String ADDRESS_COLUMN = "address";

    private Long id;
    private String address;
    private Set<Items> items = new HashSet<Items>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Warehouses{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}

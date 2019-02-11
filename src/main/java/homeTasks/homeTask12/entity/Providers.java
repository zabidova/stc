package homeTasks.homeTask12.entity;

import java.util.HashSet;
import java.util.Set;

public class Providers {
    private String name;
    private Long id;
    private Set<Items> items = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Providers{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

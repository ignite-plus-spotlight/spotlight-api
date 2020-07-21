package spring.spot.Entity;

import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;


@Table()
public class Roles {

    @Id
    @NotNull
    @Column()
    private String role_name;
    @Column
    private String description;

    public Roles(String role_name, String description) {
        this.role_name = role_name;
        this.description = description;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
package spring.spot.trial.Entity;

import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table()
public class Roles {

    @Id
    @NotNull
    @Column("role_name")
    private String roleName;
    @Column
    private String description;

    public Roles(String role_name, String description) {
        this.roleName = role_name;
        this.description = description;
    }

    public String getRole_name() {
        return roleName;
    }

    public void setRole_name(String role_name) {
        this.roleName = role_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
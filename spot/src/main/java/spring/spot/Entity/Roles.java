package spring.spot.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import spring.spot.Key.RolesKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table()
public class Roles {

    @PrimaryKey
    private RolesKey rolesKey;

    @Column
    private String description;


}
package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table()
public class Roles implements Serializable {

  @PrimaryKeyColumn(name = "role_name",ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String roleName;
    @Column
    private String description;
    @Column
    private LocalDateTime timestamp;

}

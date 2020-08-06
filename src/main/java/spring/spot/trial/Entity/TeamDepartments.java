package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

/*For VP to add teams*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("team_departments")
public class TeamDepartments implements Serializable {
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    public String department;
    @PrimaryKeyColumn(name = "team_id", ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public int teamId;
}

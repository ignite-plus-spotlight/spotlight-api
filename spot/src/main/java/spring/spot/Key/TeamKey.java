package spring.spot.Key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class TeamKey implements Serializable {

    @PrimaryKeyColumn(name = "team_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    public int teamId;
}

package spring.spot.Key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamAwardsKey implements Serializable {

    @PrimaryKeyColumn(name = "team_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public int teamId;

    @PrimaryKeyColumn(name = "period_name",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    public int periodName;

}

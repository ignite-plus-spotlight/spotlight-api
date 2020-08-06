package spring.spot.trial.Entity;

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
@Table("category_teams")
public class CategoryTeams implements Serializable {
    @PrimaryKeyColumn(name = "category_name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    public String categoryName;
    @PrimaryKeyColumn(name = "team_id", ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public int teamId;
}

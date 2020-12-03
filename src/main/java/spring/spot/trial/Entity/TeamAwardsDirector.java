package spring.spot.trial.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("team_awards_director")
public class TeamAwardsDirector {
    @PrimaryKeyColumn(name = "awarded_by_id",ordinal = 0,type= PrimaryKeyType.PARTITIONED)
    public String awardedById;

    @PrimaryKeyColumn(name = "team_id",ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    public int teamId;

    @PrimaryKeyColumn(ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    private java.util.Date timestamp;


}

package spring.spot.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import spring.spot.Key.TeamAwardsKey;

@Table()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamAwards {

    @PrimaryKey
    TeamAwardsKey teamAwardsKey;

    @Column("award_name")
    private String awardName;
    @Column("team_points")
    private int teamPoints;
    @Column("awarded_by")
    private int awardedBy;


}

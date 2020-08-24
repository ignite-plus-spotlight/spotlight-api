package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("activity_feed")
public class ActivityFeed implements Serializable {
    @PrimaryKeyColumn(name="who", ordinal= 0,type= PrimaryKeyType.PARTITIONED)
    private String who;
    @PrimaryKeyColumn(ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private java.util.Date timestamp;
    @Column("award_name")
    private String awardName;
    @Column
    private int points;
    @Column
    private String imgsrc;
    @Column
    private String description;
    @Column("emp_id")
    public String empId;
    @Column("team_id")
    public String teamId;
}

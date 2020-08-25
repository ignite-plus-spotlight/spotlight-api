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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("activity_feed")
public class ActivityFeed implements Serializable {
    @PrimaryKeyColumn(name="awardee_id", ordinal= 0,type= PrimaryKeyType.PARTITIONED)
    public String awardeeId;
    @PrimaryKeyColumn(ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private LocalDateTime timestamp;
    @Column("award_name")
    private String awardName;
    @Column
    private int points;
    @Column
    private String imgsrc;
    @Column
    private String description;
}

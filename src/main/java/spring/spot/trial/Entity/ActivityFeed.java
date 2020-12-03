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
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("activity_feed")
public class ActivityFeed implements Serializable {
    @PrimaryKeyColumn(name="awardee_id", ordinal= 0,type= PrimaryKeyType.PARTITIONED)
    public String awardeeId;
    @PrimaryKeyColumn(ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    private UUID uuid;
    @Column("award_id")
    private LocalDateTime timestamp;
    @Column("awardee_name")
    private String awardeeName;
    @Column("award_name")
    private String awardName;
    @Column
    private int points;
    @Column
    private int likes;
    @Column
    private String imgsrc;
    @Column
    private String description;
}
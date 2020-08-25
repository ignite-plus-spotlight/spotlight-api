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

/*Give away an award to a team*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("award_to_team")
public class AwardToTeam implements Serializable {
    @PrimaryKeyColumn(ordinal = 0,type= PrimaryKeyType.PARTITIONED)
    private String department;
    @PrimaryKeyColumn(name="period_name", ordinal=0,type= PrimaryKeyType.CLUSTERED)
    private String periodName;
   @PrimaryKeyColumn(name="award_name", ordinal= 1,type= PrimaryKeyType.CLUSTERED)
    @Column("award_name")
    private String awardName;
    @Column()
    private String description;
    @Column()
    private int points;
    @Column
    private LocalDateTime timestamp;
    @Column
    private String imgsrc;
}

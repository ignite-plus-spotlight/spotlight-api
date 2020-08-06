package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

/*Give away an award to individual*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("award_to_individual")
public class AwardToIndividual implements Serializable {
    @PrimaryKeyColumn(name="award_name", ordinal= 0,type= PrimaryKeyType.PARTITIONED)
    private String awardName;
    @PrimaryKeyColumn(ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public String department;
    @PrimaryKeyColumn(name="period_name", ordinal=1,type=PrimaryKeyType.CLUSTERED)
    private String periodName;
    @Column()
    private String description;
    @Column()
    private int points;
    @Column
    private java.util.Date timestamp;
    @Column
    private String imgsrc;
}

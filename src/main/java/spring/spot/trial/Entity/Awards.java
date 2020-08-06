package spring.spot.trial.Entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table()
@Getter
@Setter
public class Awards implements Serializable {
    @PrimaryKeyColumn(name="award_name", ordinal= 0,type= PrimaryKeyType.PARTITIONED)
    private String awardName;
    @PrimaryKeyColumn(name="period_name", ordinal=0,type=PrimaryKeyType.CLUSTERED)
    private String periodName;
    @PrimaryKeyColumn(name = "category", ordinal = 1,type=PrimaryKeyType.CLUSTERED)
    //@Column
    private String category;
    @Column()
    private String description;
    @Column()
    private int points;
}

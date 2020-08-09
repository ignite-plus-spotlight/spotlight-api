package spring.spot.trial.Entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

/*Received team awards that are displayed in team member dashboard*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("team_awards_received_tmd")
@Getter
@Setter
public class TeamAwardsTMD implements Serializable {

    @PrimaryKeyColumn(name = "team_id",ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    public int teamId;

    @PrimaryKeyColumn(name = "employee_id",ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    public String employeeId;

    @Column
    public String department;

    @Column("period_name")
    public  String periodName;

    @PrimaryKeyColumn(name = "award_name", ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    private String awardName;

    @Column("team_points")
    private int teamPoints;

    @Column("team_name")
    private String teamName;

    @Column
    private String description;

    @Column
    private Date timestamp;

    @Column
    private String imgsrc;


}

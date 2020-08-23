package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Table("team_awards_received")
public class TeamAwardsTMD implements Serializable {

    @PrimaryKeyColumn(name = "given_by_id",ordinal = 1,type= PrimaryKeyType.PARTITIONED)
    public String employeeId;

    @PrimaryKeyColumn(name = "team_id",ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    public int teamId;

    @Column
    public String department; 

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

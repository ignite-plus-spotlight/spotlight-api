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
@Table("individual_team_awards")
public class IndividualTeamAwards implements Serializable {
    @PrimaryKeyColumn(name = "emp_id",ordinal = 1,type= PrimaryKeyType.PARTITIONED)
    public String empId;
    @PrimaryKeyColumn(ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private java.util.Date timestamp;
    @Column("team_id")
    private int teamId;
}

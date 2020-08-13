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
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table()
public class Team implements Serializable {

    @PrimaryKeyColumn(name = "manager_id", ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String managerId;

    @PrimaryKeyColumn(name = "team_id", ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private int teamId;

    @Column("team_name")
    private String teamName;

    @Column()
    private List<String> members;

    @Column
    private Date timestamp;
}

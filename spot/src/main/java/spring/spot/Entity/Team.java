package spring.spot.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import spring.spot.Key.TeamKey;

@Table()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @PrimaryKey
    private TeamKey teamKey;

    @Column("team_name")
    private String teamName;
    @Column("emp_m_id")
    private int empMId;


}
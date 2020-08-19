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

//vp gets this list to approve and award those whom he approved

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("approval")
public class Approval implements Serializable {

    @PrimaryKeyColumn(name = "approved_by_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String approvedById; //goes to emp_awards tableS as awarded_by_id

    @Column("nomination_id")
    public UUID nominationId;

    @Column("nominee_id")
    public String nominee_id; //goes to emp_awards as emp_id

    @Column("nominee_name")
    public String nomineeName;

    @Column("manager_id")
    public String managerId; //take head_id from nom approval dto

    @Column("manager_name")
    public String managerName;  //take head.first name+ last name from nominations approval dto

    @Column()
    private String description;

    @Column("director_name")
    private String directorName; //your name

    @Column("process_id")
    private UUID processId;  //take poll id from nominations approval dto

    @Column("process_end_date")
    private LocalDateTime endDate;

}

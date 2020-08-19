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

/*Awards received by Individual team dashboard*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("emp_awards_received_tm")
public class EmployeeAwardsTM implements Serializable {

    @PrimaryKeyColumn(name = "emp_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String empId;

    @PrimaryKeyColumn(name = "period_name",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public String periodName;

    @PrimaryKeyColumn(name = "awarded_by_id",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    private String awardedById;

    @PrimaryKeyColumn(name = "department", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    public String department;

    @PrimaryKeyColumn(name = "award_name", ordinal = 3, type = PrimaryKeyType.CLUSTERED)
    public String awardName;

    @Column("emp_points")
    private int empPoints;

    @Column("manager_name")
    private String managerName;

    @PrimaryKeyColumn(ordinal = 4, type = PrimaryKeyType.CLUSTERED)
    private LocalDateTime timestamp;

    @Column
    private String imgsrc;

    @Column
    private String description;
}

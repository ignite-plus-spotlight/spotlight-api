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

/*Awards received by Individual in manager dashboard*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("emp_awards_received_m")
public class EmployeeAwardsMD implements Serializable {

    @PrimaryKeyColumn(name = "awarded_by_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String awardedById;

    @PrimaryKeyColumn(name = "emp_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private String empId;

    @PrimaryKeyColumn(name = "period_name",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    public String periodName;

    @PrimaryKeyColumn(name = "department", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    public String department;

    @PrimaryKeyColumn(name = "award_name", ordinal = 3, type = PrimaryKeyType.CLUSTERED)
    public String awardName;

    @Column("emp_points")
    private int empPoints;


    @Column("head_name")
    private String headName;

    @Column
    private Date timestamp;

    @Column
    private String imgsrc;

    @Column
    private String description;

}

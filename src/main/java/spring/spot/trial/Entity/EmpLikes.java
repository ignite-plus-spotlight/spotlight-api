package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("emp_likes")
public class EmpLikes {
    @PrimaryKeyColumn(name="awardee_id", ordinal= 0,type= PrimaryKeyType.PARTITIONED)
    public String awardeeId;
    @PrimaryKeyColumn(ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private UUID uuid;
    @PrimaryKeyColumn(name = "emp_id",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    private String empId;
}
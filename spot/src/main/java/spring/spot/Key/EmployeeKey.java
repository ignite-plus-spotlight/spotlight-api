package spring.spot.Key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@Data
@PrimaryKeyClass
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeKey implements Serializable {
    @PrimaryKeyColumn(name = "emp_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public int empId;

    @PrimaryKeyColumn(name = "first_name",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public String firstName;

}

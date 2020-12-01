package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("employee")
public class Employee implements Serializable {
    @PrimaryKeyColumn(name = "emp_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String empId;
    @PrimaryKeyColumn(name="first_name",ordinal = 1,type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING )
    public String firstName;
    @NotNull
    @Column("emp_email")
    private String empEmail;
    @Column("last_name")
    private String lastName;
    @Column("provider_name")
    private String providerName;
    @Column("image_url")
    private String imageUrl;
    @Column("team_id")
    private List<Integer> teamId;
    @Column
    private String dob;
    @Column
    private LocalDateTime timestamp;
}

package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.List;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor

public class Nominations implements Serializable {

    @PrimaryKeyColumn(name ="poll_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String pollId;
    @PrimaryKeyColumn(name = "nomination_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public String nominationId;

    @NotNull
    @Column("emp_id")
    private String employeeId;

    @NotNull
    @Column("manager_id")
    private String managerId;

    @NotNull
    @Column()
    private List<String> description;

}
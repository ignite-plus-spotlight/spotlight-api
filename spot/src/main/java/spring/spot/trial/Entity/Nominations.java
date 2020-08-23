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
import java.util.UUID;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor

public class Nominations implements Serializable {

    /* director alert "nomination dto" based on manager ids and (if nomStart<today<nomenddate) under him, he should get the nominations*/
    /*Once the approval table has this particular manager_id and poll_id, it shouldn't tell the director*/

    @PrimaryKeyColumn(name = "head_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String managerId; //goes as approval id

    @PrimaryKeyColumn(name = "process_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public UUID pollId;

    @Column("nomination_id")
    public UUID nominationId;

    @NotNull
    @Column("emp_id")       //nominee
    private String employeeId;

    @Column
    private String period;

    //nominated_by's message
    @NotNull
    @Column()
    private String description;
}

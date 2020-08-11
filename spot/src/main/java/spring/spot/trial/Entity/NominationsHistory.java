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
import java.util.Date;

@Data
@Table("nominations_history")
@AllArgsConstructor
@NoArgsConstructor

public class NominationsHistory implements Serializable {

    @PrimaryKeyColumn(name ="manger_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String managerId;

    @PrimaryKeyColumn(name="nomination_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public String nominationId;

    @PrimaryKeyColumn(name = "emp_id",ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    public String employeeId;

    @NotNull
    @Column("poll_name")
    private String pollName;

    @Column("created_date")
    private Date createdDate;
}

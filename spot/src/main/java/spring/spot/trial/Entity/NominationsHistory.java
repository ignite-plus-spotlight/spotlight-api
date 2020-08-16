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
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("nominations_history")
@AllArgsConstructor
@NoArgsConstructor

public class NominationsHistory implements Serializable {

    @PrimaryKeyColumn(name ="manager_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String managerId;

    @PrimaryKeyColumn(name="created_date",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private LocalDateTime createdDate;

    @Column
    public UUID nominationId;

    @Column
    public String employeeId;

    @NotNull
    @Column("poll_name")
    private String pollName;

    @Column
    private String description;
}

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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("rejected_nominations")
public class RejectedNominations implements Serializable {

    @PrimaryKeyColumn(name = "rejected_by_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String rejectedById;  //director id

    @PrimaryKeyColumn(name = "process_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private UUID processId;

    @PrimaryKeyColumn(name = "nominee_id",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    public String nomineeId;

    @Column("nomination_id")
    public UUID nominationId;

    @Column("nominee_name")
    public String nomineeName;

    @Column("manager_id")
    public String managerId;

    @Column("manager_name")
    public String managerName;

    @Column()
    private String description;

    @Column("director_name")
    private String directorName;

    @Column("process_end_date")
    private LocalDateTime endDate;

}

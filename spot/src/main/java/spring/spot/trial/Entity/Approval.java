package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("approval")
public class Approval implements Serializable {

    @PrimaryKeyColumn(name = "approved_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String managerId;

    @Column("nomination_id")
    public UUID nominationId;

    @Column("nominee_name")
    public String nomineeName;

    @Column("manager_name")
    public String managerName;

    @Column()
    private String description;

    @Column("director_id")
    private String directorId;

    @Column("director_name")
    private String directorName;
}

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

    @PrimaryKeyColumn(name = "nomination_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public UUID nominationId;
    @PrimaryKeyColumn(name = "head_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public String headId;

    @Column()
    private String description;
    @Column()
    private String superHeadId;
    @Column()
    private String superHeadName;

}

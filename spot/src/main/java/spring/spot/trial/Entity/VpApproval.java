package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("vp_approval")
public class VpApproval {
    @PrimaryKeyColumn(name = "approved_by_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String approvedById;
    @PrimaryKeyColumn(name = "process_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private UUID processId;
    @PrimaryKeyColumn(name = "nominee_id",ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    public String nomineeId;
}

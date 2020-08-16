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
@Table("poll_status")
public class PollStatus implements Serializable {

    @PrimaryKeyColumn(name = "poll_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public UUID pollId;
    @PrimaryKeyColumn(name = "nomination_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public UUID nominationId;
    @Column
    public int voteCount=0;

}

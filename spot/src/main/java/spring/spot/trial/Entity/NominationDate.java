package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("nomination_date")
public class NominationDate implements Serializable {

    @PrimaryKeyColumn(name = "nomination_start_date", ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private Date nominationStartDate;

    @PrimaryKeyColumn(name = "nomination_end_date", ordinal = 1,type = PrimaryKeyType.PARTITIONED)
    private Date nominationEndDate;

    @Generated
    @Column("poll_id")
    private UUID pollId;

}

package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("polling_date")
public class PollingDate {
    @PrimaryKeyColumn(name = "poll_start_date", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Date pollStartDate;

    @PrimaryKeyColumn(name = "poll_end_date", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private Date pollEndDate;

    @Column("poll_id")
    private String pollName;
}

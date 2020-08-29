package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("process_date")
public class PollingDate {
    @PrimaryKeyColumn(name = "process_start_date", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private LocalDateTime pollStartDate;

    @PrimaryKeyColumn(name = "process_end_date", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private LocalDateTime pollEndDate;

    @Column("process_name")
    private String pollName;

    @Column("process_id")
    private UUID pollId;
}

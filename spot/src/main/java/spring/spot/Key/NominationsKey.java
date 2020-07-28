package spring.spot.Key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class NominationsKey {

    @PrimaryKeyColumn(name = "nominee", ordinal =0, type = PrimaryKeyType.PARTITIONED)
    public int nominee;

    @PrimaryKeyColumn(name = "period_name",ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    public String periodName;

    @PrimaryKeyColumn(name = "category_name",ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    public String categoryName;


}

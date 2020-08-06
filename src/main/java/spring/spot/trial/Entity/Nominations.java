package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table()
public class Nominations implements Serializable {

    @PrimaryKeyColumn(name = "manager_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String managerId;
    @PrimaryKeyColumn(name = "nominee_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    public String nomineeId;
    @PrimaryKeyColumn(name = "period_name",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    public String periodName;
    @PrimaryKeyColumn(name = "category_name",ordinal = 2,type = PrimaryKeyType.CLUSTERED)
    public String categoryName;
    @Column("nominee_name")
    public String nomineeName;
    @Column("award_name")
    private String awardName;
    @Column("manager_name")
    private String managerName;
}

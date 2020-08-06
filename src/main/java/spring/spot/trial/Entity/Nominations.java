package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

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
    @Column
    private java.util.Date timestamp;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(String nomineeId) {
        this.nomineeId = nomineeId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

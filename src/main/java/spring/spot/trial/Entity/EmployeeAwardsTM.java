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

/*Awards received by Individual team dashboard*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("emp_awards_received_tm")
public class EmployeeAwardsTM implements Serializable {

    @PrimaryKeyColumn(name = "emp_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    public String empId;

    @PrimaryKeyColumn(name = "awarded_by_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private String awardedById;

    @PrimaryKeyColumn(name = "period_name",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    public String periodName;

    @PrimaryKeyColumn(name = "department", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    public String department;

    @PrimaryKeyColumn(name = "award_name", ordinal = 3, type = PrimaryKeyType.CLUSTERED)
    public String awardName;

    @Column("emp_points")
    private int empPoints;

    @Column("manager_name")
    private String managerName;

    @Column
    private java.util.Date timestamp;

    @Column
    private String imgsrc;

    @Column
    private String description;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public int getEmpPoints() {
        return empPoints;
    }

    public void setEmpPoints(int empPoints) {
        this.empPoints = empPoints;
    }

    public String getAwardedById() {
        return awardedById;
    }

    public void setAwardedById(String awardedById) {
        this.awardedById = awardedById;
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

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


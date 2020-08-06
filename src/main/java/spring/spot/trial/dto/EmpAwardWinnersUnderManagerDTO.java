package spring.spot.trial.dto;

//Employee details of all employees(role=team member) who have received awards/s from a particular manager
import spring.spot.trial.Entity.Employee;

import java.util.Date;
import java.util.List;

public class EmpAwardWinnersUnderManagerDTO {
    private Employee employee;
    public String awardedById;
    public String periodName;
    public String department;
    public String awardName;
    private int empPoints;
    private String empId;
    private String managerName;
    private java.util.Date timestamp;
    private String imgsrc;
    private String description;

    @Override
    public String toString() {
        return "EmpAwardWinnersUnderManagerDTO{" +
                "employee=" + employee +
                ", awardedById='" + awardedById + '\'' +
                ", periodName='" + periodName + '\'' +
                ", department='" + department + '\'' +
                ", awardName='" + awardName + '\'' +
                ", empPoints=" + empPoints +
                ", empId='" + empId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", timestamp=" + timestamp +
                ", imgsrc='" + imgsrc + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAwardedById() {
        return awardedById;
    }

    public void setAwardedById(String awardedById) {
        this.awardedById = awardedById;
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

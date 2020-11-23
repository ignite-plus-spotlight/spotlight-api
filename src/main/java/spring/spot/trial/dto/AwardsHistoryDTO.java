package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.time.LocalDateTime;

@Data
public class AwardsHistoryDTO {

    public String awardedById;

    private String empId;

    private Employee employee;

    public String periodName;

    public String department;

    public String awardName;

    private int empPoints;

    private String managerName;

    private LocalDateTime timestamp;

    private String imgsrc;

    private String description;

}

package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.util.List;

//details of the employees down the hierarchy
@Data
public class HierarchyDTO {
    private Employee value;
    private List<HierarchyDTO> children;
}

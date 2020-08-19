package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.util.List;

@Data
public class VpDTO {
    private Employee employee;
    List<DirectorDTO> directorDTOS;
}

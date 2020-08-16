package spring.spot.trial.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PollProcessDTO {
    private UUID pollId;
    private List<NominationDTO> nominationDTOS;
}

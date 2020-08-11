package spring.spot.trial.dto;

import lombok.Data;

import java.util.List;

@Data
public class PollProcessDTO {
    private String pollId;
    private List<NominationDTO> nominationDTOS;
}

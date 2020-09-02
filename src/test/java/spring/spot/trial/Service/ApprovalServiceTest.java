package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.Approval;
import spring.spot.trial.Repository.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApprovalServiceTest {
    ApprovalRepository approvalRepository=mock(ApprovalRepository.class);
    TeamRepository teamRepository=mock(TeamRepository.class);
    PollRepository pollRepository=mock(PollRepository.class);
    EmployeeRepository employeeRepository=mock(EmployeeRepository.class);
    EmployeeAwardsTMRepository employeeAwardsTMRepository=mock(EmployeeAwardsTMRepository.class);
    EmployeeAwardsMRepository employeeAwardsMRepository=mock(EmployeeAwardsMRepository.class);
    RejectedNominationsRepository rejectedNominationsRepository=mock(RejectedNominationsRepository.class);

    @InjectMocks
    ApprovalService approvalService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createApproval(){
        Approval approval=new Approval();
        approval.setApprovedById("123");
        approval.setDescription("Meets the requirement");
        approval.setDirectorName("Rithika");
        approval.setManagerName("Anusha");
        when(approvalRepository.save(any())).thenReturn(approval);
        Approval response = approvalService.createApproval(approval);
        assertEquals("123",response.getApprovedById());
    }

    @Test
    public void getAllApprovals(){
        List<Approval> approvals=new ArrayList<>();
        Approval approval1=new Approval();
        approval1.setApprovedById("123");
        approval1.setDescription("Meets the requirement");
        approval1.setDirectorName("Rithika");
        approval1.setManagerName("Anusha");

        Approval approval2=new Approval();
        approval2.setApprovedById("456");
        approval2.setDescription("Meets the requirement");
        approval2.setDirectorName("Deepika");
        approval2.setManagerName("Walusha");

        approvals.add(approval1);
        approvals.add(approval2);
        when(approvalRepository.findAll()).thenReturn(approvals);
        List<Approval> approval=approvalService.getAllApprovals();
        assertEquals(2,approval.size());
    }

    @Test
    public void   getApprovalByHeadId(){
        List<Approval> approvals=new ArrayList<>();
        Approval approval1=new Approval();
        approval1.setApprovedById("123");
        approval1.setDescription("Meets the requirement");
        approval1.setDirectorName("Rithika");
        approval1.setManagerName("Anusha");

        approvals.add(approval1);

        when(approvalRepository.findByApprovedById(any())).thenReturn(approvals);
        List<Approval> approvalList = approvalService.getApprovalByHeadId(approval1.getApprovedById());
        assertEquals("Anusha",approvalList.get(0).getManagerName());

    }
}

package spring.spot.Entity;

import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table()
public class Team {

    @Id
    @Column()
    @NotNull
    private int team_id;

    @Column()
    private String team_name;
    @Column
    private int emp_m_id;

    public Team(int team_id, String team_name, int emp_m_id) {
        this.team_id = team_id;
        this.team_name = team_name;
        this.emp_m_id = emp_m_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getEmp_m_id() {
        return emp_m_id;
    }

    public void setEmp_m_id(int emp_m_id) {
        this.emp_m_id = emp_m_id;
    }
}
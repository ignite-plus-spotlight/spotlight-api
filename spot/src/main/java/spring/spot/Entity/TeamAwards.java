package spring.spot.Entity;
import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value="teamawards")
public class TeamAwards {

    @Id
    @Column()
    @NotNull
    private int team_id;

    @NotNull
    @Column()
    private String period_name;

    @Column
    private String award_name;
    @Column()
    private int team_points;
    @Column()
    private int awarded_by;

    public TeamAwards(int team_id, String period_name, String award_name, int team_points, int awarded_by) {
        this.team_id = team_id;
        this.period_name = period_name;
        this.award_name = award_name;
        this.team_points = team_points;
        this.awarded_by = awarded_by;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getAward_name() {
        return award_name;
    }

    public void setAward_name(String award_name) {
        this.award_name = award_name;
    }

    public int getTeam_points() {
        return team_points;
    }

    public void setTeam_points(int team_points) {
        this.team_points = team_points;
    }

    public int getAwarded_by() {
        return awarded_by;
    }

    public void setAwarded_by(int awarded_by) {
        this.awarded_by = awarded_by;
    }

    @Override
    public String toString() {
        return "TeamAwards{" +
                "team_id=" + team_id +
                ", period_name='" + period_name + '\'' +
                ", award_name='" + award_name + '\'' +
                ", team_points=" + team_points + '\'' +
                ",awarded_by=" + awarded_by + '\'' +
                '}';
    }

}

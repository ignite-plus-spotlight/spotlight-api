package spring.spot.Entity;

import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table()
public class Nominations {

    @Id
    @Column()
    @NotNull
    private int nominee;

    @Column()
    private String period_name;
    @Column
    private String category_name;
    @Column()
    private String award_name;

    @Column()
    private int nominated_by;

    public Nominations(int nominee, String period_name, String category_name, String award_name, int nominated_by) {
        this.nominee = nominee;
        this.period_name = period_name;
        this.category_name = category_name;
        this.award_name = award_name;
        this.nominated_by = nominated_by;
    }

    public int getNominee() {
        return nominee;
    }

    public void setNominee(int nominee) {
        this.nominee = nominee;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getAward_name() {
        return award_name;
    }

    public void setAward_name(String award_name) {
        this.award_name = award_name;
    }

    public int getNominated_by() {
        return nominated_by;
    }

    public void setNominated_by(int nominated_by) {
        this.nominated_by = nominated_by;
    }
}

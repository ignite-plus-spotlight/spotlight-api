package spring.spot.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import spring.spot.Key.NominationsKey;

@Table()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nominations {

    @PrimaryKey
    private NominationsKey nominationsKey;


    @Column("award_name")
    private String awardName;

    @Column("nominated_by")
    private int nominatedBy;


}

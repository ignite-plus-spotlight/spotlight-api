package spring.spot.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import spring.spot.Key.EmployeeKey;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("employee")
public class Employee {

    @PrimaryKey
    private EmployeeKey employeeKey;
    @NotNull
    @Column("emp_email")
    private String empEmail;
    @Column
    private String gender;
    @Column("last_name")
    private String lastName;
}

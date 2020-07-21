package spring.spot.Entity;

import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;



import java.util.ArrayList;

@Table()
public class Employee {

    @Id
    @Column()
    @NotNull
    private int emp_id;

    @NotNull
    @Column()
    private String emp_email;
    @Column
    private String gender;
    @Column()
    private String first_name;

    @Column()
    private String last_name;

    public Employee(int emp_id, String first_name, String emp_email, String last_name, String gender) {
        this.emp_id = emp_id;
        this.first_name = first_name;
        this.emp_email = emp_email;
        this.last_name = last_name;
        this.gender=gender;
    }

    public int getEmpId() {
        return emp_id;
    }

    public void setEmpId(int emp_id) {
        this.emp_id = emp_id;
    }



    public String getEmpEmail() {
        return emp_email;
    }

    public void setEmpEmail(String emp_email) {
        this.emp_email = emp_email;
    }



    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getGender()
    {
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_email='" + emp_email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name=" + last_name +'\''+
                ",gender=" + gender+'\''+
                '}';
    }
}

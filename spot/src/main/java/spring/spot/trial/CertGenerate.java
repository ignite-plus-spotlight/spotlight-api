package spring.spot.trial;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.EmployeeAwardsTM;

import java.io.StringWriter;

public class CertGenerate {
    public static String certGenerate(Employee employee, EmployeeAwardsTM employeeAwardsTM) throws Exception {

        VelocityEngine ve = new VelocityEngine();
        ve.init();

        VelocityContext context = new VelocityContext();
        context.put("name", employee.getFirstName()+" "+employee.getLastName());
        context.put("description", employeeAwardsTM.getDescription());

        Template t =  ve.getTemplate( CertGenerate.class.getClassLoader().getResource("certificate.vm").getPath() );


        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        return writer.toString();
    }
}

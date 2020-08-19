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
        context.put("description", "for being someone we can always count on! I'm so grateful for all of your hard work. " +
                "The entire team thanks you for everything you do. It's rare to come across people who are so dedicated and trustworthy");

        Template t = ve.getTemplate("src/main/resources/certificate.vm");

        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        return writer.toString();
    }
}

package spring.spot.trial;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.EmployeeAwardsTM;
import spring.spot.trial.Entity.TeamAwardsTMD;

import java.io.StringWriter;

public class CertGenerate {

    public String certGenerate(Employee employee, EmployeeAwardsTM employeeAwardsTM) throws Exception {

        VelocityEngine ve = new VelocityEngine();
        ve.init();

        VelocityContext context = new VelocityContext();
        context.put("name",employee.getFirstName()+" "+employee.getLastName());
        context.put("description",employeeAwardsTM.getDescription());
        context.put("award",employeeAwardsTM.getAwardName());

        Template t = ve.getTemplate("src/main/resources/certificate.vm");

        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        return writer.toString();
    }

    public String teamCertGenerate(Employee employee, TeamAwardsTMD teamAwardsTMD) throws Exception {

        VelocityEngine ve = new VelocityEngine();
        ve.init();

        VelocityContext context = new VelocityContext();
        context.put("name",employee.getFirstName()+" "+employee.getLastName());
        context.put("description",teamAwardsTMD.getDescription());
        context.put("award",teamAwardsTMD.getAwardName());

        Template t = ve.getTemplate("src/main/resources/certificate.vm");

        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        return writer.toString();
    }

}
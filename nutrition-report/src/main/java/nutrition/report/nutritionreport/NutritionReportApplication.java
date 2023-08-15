package nutrition.report.nutritionreport;

import net.sf.jasperreports.engine.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class NutritionReportApplication {

    public static void main(String[] args) throws JRException {
        SpringApplication.run(NutritionReportApplication.class, args);

        String filePath = "C:\\Users\\asus\\Downloads\\nutrition-report\\nutrition-report\\src\\main\\resources\\templates\\nutritionreport.jrxml";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("firstName", "Marzhan");
        parameters.put("lastName", "Nuraly");
        parameters.put("dob", "25.09.2002");
        parameters.put("age", 20);

        JasperReport report = JasperCompileManager.compileReport(filePath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\asus\\Downloads\\nutrition-report\\nutrition-report\\src\\main\\resources\\static\\nutrition_report.pdf");
        System.out.println("Report generated successfully");
    }

}

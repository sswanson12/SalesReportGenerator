package edu.wctc;

import edu.wctc.implementations.SalesInput;
import edu.wctc.implementations.salesReports.DetailedSalesReport;
import edu.wctc.interfaces.ISalesInput;
import edu.wctc.interfaces.ISalesReport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;

public class SalesReportGeneratorApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        var salesInput = (ISalesInput)context.getBean("iSalesInput");

        var salesReport = (ISalesReport)context.getBean("iSalesReport");

        try {
            salesReport.generateReport(salesInput.getSales("src/main/java/edu/wctc/data/sales.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

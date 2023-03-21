package edu.wctc;

import edu.wctc.data.SalesCsvTranslator;
import edu.wctc.implementations.SalesInput;
import edu.wctc.implementations.inputOutput.CommandLineTable;
import edu.wctc.implementations.salesReports.DetailedSalesReport;
import edu.wctc.implementations.salesReports.SummarySalesReport;
import edu.wctc.implementations.shippingPolicies.flatRateDomesticShipping;
import edu.wctc.implementations.shippingPolicies.freeShipping;
import edu.wctc.implementations.shippingPolicies.freeShippingOver100;
import edu.wctc.interfaces.ICsvTranslator;
import edu.wctc.interfaces.ISalesInput;
import edu.wctc.interfaces.ISalesReport;
import edu.wctc.interfaces.IShippingPolicy;
import edu.wctc.models.Sale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.wctc")
public class AppConfig {


    @Bean
    CommandLineTable commandLineTable(){
        return new CommandLineTable();
    }

    @Bean
    ISalesReport iSalesReport(){
        return new SummarySalesReport(commandLineTable());
    }

    @Bean
    ICsvTranslator iCsvTranslator(){
        return new SalesCsvTranslator();
    }

    @Bean
    IShippingPolicy iShippingPolicy(){
        return new freeShipping();
    }

    @Bean
    ISalesInput iSalesInput(){
        return new SalesInput();
    }
}

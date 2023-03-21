package com.example.springassignment;

import edu.wctc.implementations.inputOutput.CommandLineTable;
import edu.wctc.implementations.salesReports.DetailedSalesReport;
import edu.wctc.implementations.shippingPolicies.freeShippingOver100;
import edu.wctc.interfaces.ISalesReport;
import edu.wctc.interfaces.IShippingPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.wctc")
public class AppConfig {
    @Bean
    IShippingPolicy shippingPolicy(){
        return new freeShippingOver100();
    }

    @Bean
    ISalesReport salesReport(){
        return new DetailedSalesReport(new CommandLineTable());
    }
}

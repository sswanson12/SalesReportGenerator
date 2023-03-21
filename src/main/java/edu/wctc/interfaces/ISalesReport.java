package edu.wctc.interfaces;

import edu.wctc.models.Sale;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ISalesReport {
    void generateReport(List<Sale> salesList);
}

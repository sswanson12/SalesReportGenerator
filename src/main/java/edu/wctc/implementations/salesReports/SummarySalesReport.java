package edu.wctc.implementations.salesReports;
import edu.wctc.implementations.inputOutput.CommandLineTable;
import edu.wctc.interfaces.ISalesReport;
import edu.wctc.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SummarySalesReport implements ISalesReport {

    @Autowired
    public SummarySalesReport(CommandLineTable consoleTable) {
    }

    @Override
    public void generateReport(List<Sale> salesList) {
        CommandLineTable consoleTable = new CommandLineTable();

        consoleTable.setHeaders("Country", "Amount", "Tax", "Shipping");

        for (Sale sale: salesList) {
            consoleTable.addRow(sale.getCountry(), "" + sale.getTotal(), "" + sale.getTax(), "" + sale.getShipping());
        }

        consoleTable.print();
    }
}

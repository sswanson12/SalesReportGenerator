package edu.wctc.implementations.salesReports;

import edu.wctc.implementations.inputOutput.CommandLineTable;
import edu.wctc.interfaces.ISalesReport;
import edu.wctc.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DetailedSalesReport implements ISalesReport {

    @Autowired
    public DetailedSalesReport(CommandLineTable consoleTable) {
    }

    @Override
    public void generateReport(List<Sale> salesList) {
        CommandLineTable consoleTable = new CommandLineTable();

        consoleTable.setHeaders("Customer","Country", "Amount", "Tax", "Shipping");

        for (Sale sale : salesList) {
            consoleTable.addRow(sale.getCustomer(), sale.getCountry(), "" + sale.getTotal(), "" + sale.getTax(), "" + sale.getShipping());
        }

        consoleTable.print();
    }
}

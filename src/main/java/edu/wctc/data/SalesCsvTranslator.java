package edu.wctc.data;

import edu.wctc.interfaces.ICsvTranslator;
import edu.wctc.models.Sale;
import org.springframework.stereotype.Component;


public class SalesCsvTranslator implements ICsvTranslator<Sale> {
    @Override
    public Sale FromCsv(String csvLine) {
        var newSale = new Sale();
        var csvArray = csvLine.split(",");

        newSale.setCustomer(csvArray[0]);
        newSale.setCountry(csvArray[1]);
        newSale.setTotal(Double.parseDouble(csvArray[2]));
        newSale.setTax(Double.parseDouble(csvArray[3]));

        return newSale;
    }

    @Override
    public String ToCsv(Sale item) {
        return String.format("%s,%s,%s,%s", item.getCustomer(), item.getCountry(), item.getTotal(), item.getTax());
    }
}

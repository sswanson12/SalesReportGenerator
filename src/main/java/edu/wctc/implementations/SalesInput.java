package edu.wctc.implementations;

import edu.wctc.interfaces.ICsvTranslator;
import edu.wctc.interfaces.ISalesInput;
import edu.wctc.interfaces.IShippingPolicy;
import edu.wctc.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class SalesInput implements ISalesInput {
    @Autowired
    ICsvTranslator csvTranslator;
    @Autowired
    IShippingPolicy shippingPolicy;

    @Override
    public List<Sale> getSales(String filePath) throws FileNotFoundException {
        List<Sale> salesList = new ArrayList<>();

        Scanner scanner = new Scanner(new File(filePath));

        while (scanner.hasNextLine()){
            var currentSale = (Sale)csvTranslator.FromCsv(scanner.nextLine());

            shippingPolicy.applyShipping(currentSale);

            salesList.add(currentSale);
        }

        scanner.close();

        return salesList;
    }
}

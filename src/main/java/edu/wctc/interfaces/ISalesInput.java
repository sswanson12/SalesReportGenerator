package edu.wctc.interfaces;

import edu.wctc.models.Sale;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;

@Component
public interface ISalesInput {
    List<Sale> getSales(String filePath) throws FileNotFoundException;
}

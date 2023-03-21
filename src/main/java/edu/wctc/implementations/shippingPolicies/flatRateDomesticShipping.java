package edu.wctc.implementations.shippingPolicies;

import edu.wctc.interfaces.IShippingPolicy;
import edu.wctc.models.Sale;
import org.springframework.stereotype.Component;


public class flatRateDomesticShipping implements IShippingPolicy {
    @Override
    public void applyShipping(Sale sale) {
        //Flat-Rate 15% of sale
        sale.setShipping(sale.getTotal() * 0.15);
    }
}

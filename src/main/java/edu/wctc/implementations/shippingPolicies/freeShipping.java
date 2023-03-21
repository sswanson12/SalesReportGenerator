package edu.wctc.implementations.shippingPolicies;

import edu.wctc.interfaces.IShippingPolicy;
import edu.wctc.models.Sale;
import org.springframework.stereotype.Component;


public class freeShipping implements IShippingPolicy {
    @Override
    public void applyShipping(Sale sale) {
        //No shipping cost!
        sale.setShipping(0);
    }
}

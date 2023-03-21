package edu.wctc.implementations.shippingPolicies;

import edu.wctc.interfaces.IShippingPolicy;
import edu.wctc.models.Sale;
import org.springframework.stereotype.Component;


public class freeShippingOver100 implements IShippingPolicy {
    @Override
    public void applyShipping(Sale sale) {
        //15% shipping cost unless order total is $100 or greater
        if (sale.getTotal() >= 100) {
            sale.setShipping(0);
        } else {
            sale.setShipping(sale.getTotal() * 0.15);
        }
    }
}

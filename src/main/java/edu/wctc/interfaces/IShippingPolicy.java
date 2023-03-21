package edu.wctc.interfaces;
import edu.wctc.models.Sale;
import org.springframework.stereotype.Component;

@Component
public interface IShippingPolicy {
    void applyShipping(Sale sale);
}

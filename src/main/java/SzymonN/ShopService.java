package SzymonN;

import com.mkuligowski.inventory.domain.Product;
import com.mkuligowski.inventory.domain.SlotProduct;

import java.math.BigDecimal;
import java.util.List;

public class ShopService {

    public BigDecimal ValueOfAllProducts(List<SlotProduct> slotsOfProducts)
    {
        BigDecimal itemCost;
        BigDecimal totalCost = BigDecimal.ZERO;

        for (SlotProduct s:slotsOfProducts) {
            itemCost  = s.getProduct().getPrice().multiply(new BigDecimal(s.getQuantity()));
            totalCost = totalCost.add(itemCost);
        }
        return totalCost;
    }
}

package org.shop.initializer;

import org.shop.api.SellerService;
import org.shop.data.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The Seller Initializer util class.
 */
public class SellerInitializer {

    /**
     * The seller service.
     */
    @Autowired
    private SellerService sellerService;

    /**
     * The seller names.
     */
//  @Resource(name = "sellersName")
    @Autowired
    private Map<Long, String> sellerNames = Collections.emptyMap();

    /**
     * Inits the sellers.
     */
    public void initSellers() {
        List<Seller> sellers = new LinkedList<>();

        for (Map.Entry<Long, String> entry : sellerNames.entrySet()) {
            Seller seller = new Seller();
            seller.setId(entry.getKey());
            seller.setName(entry.getValue());

            sellers.add(seller);
        }
        sellerService.importSellers(sellers);
    }

    @Override
    public String toString() {
        return "SellerInitializer{" +
                "sellerService=" + sellerService +
                ", sellerNames=" + sellerNames +
                '}';
    }
}

package org.shop;

import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.config.AppConfig;
import org.shop.data.Seller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        //TODO: implement using Spring Framework ApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}

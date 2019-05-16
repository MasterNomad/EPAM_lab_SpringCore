package org.shop;

import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.config.AppConfig;
import org.shop.repository.OrderRepository;
import org.shop.repository.ProposalRepository;
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
        System.out.println(context.getBean(ProposalRepository.class).getProposal(1L));
    }
}

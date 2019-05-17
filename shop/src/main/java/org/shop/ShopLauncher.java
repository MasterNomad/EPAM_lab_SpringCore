package org.shop;

import org.shop.config.AppConfig;
import org.shop.initializer.DataInitializer;
import org.shop.initializer.SellerInitializer;
import org.shop.repository.OrderRepository;
import org.shop.repository.ProposalRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Field;

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
        System.out.println("Call ProposalRepository.getProposal(1L)");
        context.getBean(ProposalRepository.class).getProposal(1L);

        System.out.println("+");
        System.out.println(context.getBean(SellerInitializer.class));
        System.out.println("+");
        try {
            Field field = DataInitializer.class.getDeclaredField("seller");
            field.setAccessible(true);
            System.out.println(field.get(context.getBean(DataInitializer.class)));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

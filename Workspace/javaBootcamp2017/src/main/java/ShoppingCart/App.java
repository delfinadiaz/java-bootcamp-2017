package ShoppingCart;


import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import ShoppingCart.HibernateUtil.HibernateUtil;


@SpringBootApplication
@ComponentScan
@EntityScan
public class App {

	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

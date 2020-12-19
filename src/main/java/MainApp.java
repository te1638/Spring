import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.te.spring.AppConfig;
import ru.te.spring.beans.Cart;
import ru.te.spring.service.ProductService;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        test(context);

                context.close();
    }

    public static void test(AnnotationConfigApplicationContext context) {

            Scanner scanner = new Scanner(System.in);
            Cart cart;
            int res;
            ProductService productService = context.getBean("productService", ProductService.class);
            while (true) {
                System.out.println("1 - Новая корзина, иное число - выход");
                if (scanner.nextInt() != 1) break;

                cart = context.getBean("cart", Cart.class);

                do {

                    cart.getProductMap().forEach(((product, integer) ->
                    {
                        System.out.printf("%s [%d] шт.\n", product, integer);
                    }));


                    productService.getAllProducts().forEach(System.out::println);
                    System.out.println("-----------------------------------------------------------");

                    res = scanner.nextInt();

                    if (res > 0) {
                        cart.addProductByProductID(res);
                    } else if (res < 0) {
                        cart.removeProductByProductID(-res);
                    }

                } while (res != 0);

            }


        }
    }

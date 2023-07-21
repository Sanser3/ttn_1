package e41.ttn_1;

import e41.ttn_1.entity.Customers;
import e41.ttn_1.entity.Orders;
import e41.ttn_1.entity.Ttns;
import e41.ttn_1.repository.CustomerRepository;
import e41.ttn_1.repository.OrderRepository;
import e41.ttn_1.repository.TtnRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableWebMvc
public class Ttn1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ttn1Application.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(
            // репозиторий для ролей ------------> добавить
            CustomerRepository customerRepository,
            OrderRepository orderRepository,
            TtnRepository ttnRepository){
        return args -> {
            // сохраняем роли аутентификации

            // сохраняем заказчика
            customerRepository.save(new Customers(1, "name", "address", "route", "1320906976",
                    LocalDate.now()));
            // сохраняем заказ
            Integer[] orders = new Integer[]{1,1,0,0,2};
            ArrayList<Integer> newArray = new ArrayList<>(Arrays.asList(orders));
            orderRepository.save(new Orders(1, newArray, LocalDate.now()));
            // сохраняем накладную
            ArrayList<Integer> newArray2 = new ArrayList<>();
            Collections.addAll(newArray2,orders);
            ttnRepository.save(new Ttns(
                    1,
                    new Customers(1, "name", "address", "route", "1320906976", LocalDate.now()),
                    new Orders(1, newArray2, LocalDate.now()),
                    "-1341405593",
                    LocalDate.now()));
        };
    }
}

package e41.ttn_1;

import e41.ttn_1.entity.Customers;
import e41.ttn_1.entity.Orders;
import e41.ttn_1.entity.Ttns;
import e41.ttn_1.repository.CustomerRepository;
import e41.ttn_1.repository.OrderRepository;
import e41.ttn_1.repository.TtnRepository;
//import e41.ttn_1.secutityII.Role;
//import e41.ttn_1.secutityII.RoleRepository;
//import e41.ttn_1.secutityII.User;
//import e41.ttn_1.secutityII.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
import java.util.*;

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
//            UserRepository userRepository,
//            RoleRepository roleRepository,
//            BCryptPasswordEncoder bCryptPasswordEncoder,
            CustomerRepository customerRepository,
            OrderRepository orderRepository,
            TtnRepository ttnRepository){
        return args -> {
            // сохраняем роли аутентификации
//            userRepository.save(new User(1L,"admin",
//                    bCryptPasswordEncoder.encode("adminpass"), new HashSet<>(1,1)));
//            userRepository.save(new User(2L,"user",
//                    bCryptPasswordEncoder.encode("userpass"), new HashSet<>()));
//            roleRepository.save(new Role(1L, "ADMIN", new HashSet<>()));
//            roleRepository.save(new Role(2L, "USER", new HashSet<>()));
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
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}

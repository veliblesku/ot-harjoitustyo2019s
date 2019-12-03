/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.budjetointisovellus.domain;

/**
 *
 * @author blesku
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
//@SpringBootApplication
//public class MainForTesting implements CommandLineRunner {
//
//    public static void main(String[] args) {
//        SpringApplication.run(MainForTesting.class);
//    }
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User(1L, "ja", "salasana",new Budget(new Income(2000), new Expenses(1200)));
//        userRepository.save(user);
//        
//        // Komentorivisovelluksen toiminnallisuus
//        System.out.println("Hei maailma!");
//
//        // Kyselyn suorittaminen ja tulosten listaaminen
//
//    }
//}
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainForTesting {

    public static void main(String[] args) throws Exception {
        //SpringApplication.run(MainForTesting.class, args);
        Application.launch(budjetointisovellus.ui.BudgetingUI.class, args);
    }

//    @Bean
//    public CommandLineRunner bookDemo(UserRepository userRepository) {
//        return (args) -> {
//
//            Income income = new Income(2000);
//            Expenses expenses = new Expenses(200);
//            Budget budget = new Budget();
//            budget.setExpenses(expenses);
//            budget.setIncome(income);
//            User user = new User();
//            user.setBudget(budget);
//            user.setName("aa");
//            user.setPassword("aa");
//
//            userRepository.save(user);
//            // create users
//            //userRepository.save(new User("aa", "aa", new Budget(new Income(2000), new Expenses(1000))));
//            //userRepository.save(new User("ss", "ss", new Budget(new Income(2000), new Expenses(1000))));
//
//            // fetch all books
//            System.out.println("Users found with findAll():");
//            System.out.println("---------------------------");
//            for (User u : userRepository.findAll()) {
//                System.out.println(u.toString());
//            }
//            System.out.println();
//
//        };
//    }
}

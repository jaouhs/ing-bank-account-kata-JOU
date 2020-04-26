package fr.ing.interview;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.ing.interview.dao.CustomerRepository;
import fr.ing.interview.model.Customer;

@SpringBootApplication
public class WebFluxReactiveApp {
	public static void main(String[] args) {
		SpringApplication.run(WebFluxReactiveApp.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			for (int i = 1; i <= 5; i++) {
				customerRepository.save(new Customer(null, "ING Bank", "CusID "+(int)Math.random()*1000*i, null)).subscribe(cus -> {
					System.out.println(cus);
				});
			}
		};
	}
}

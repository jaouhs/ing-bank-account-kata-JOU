package fr.ing.interview.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ing.interview.dao.CustomerRepository;
import fr.ing.interview.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerReactRestController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping(value ="/customers/{id}")
	public Mono<Customer> getOne(@PathVariable String id){
		return customerRepository.findById(id);
	}
	
	@PostMapping("/customers")
	public Mono<Customer> save(@RequestBody Customer customer){
		return customerRepository.save(customer);
	}
	
	@DeleteMapping("/customers")
	public Mono<Void> delete(@PathVariable String id){
		return customerRepository.deleteById(id);
	}
	
	@PutMapping("/customers/{id}")
	public Mono<Customer> update(@RequestBody Customer customer, @PathVariable String id){
		customer.setId(id);
		return customerRepository.save(customer);
	}
	
	@GetMapping(value ="/customers")
	public Flux<Customer> findAll(){
		return customerRepository.findAll();
	}

}

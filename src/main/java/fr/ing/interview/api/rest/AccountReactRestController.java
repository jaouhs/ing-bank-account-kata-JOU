package fr.ing.interview.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ing.interview.dao.AccountRepository;
import fr.ing.interview.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AccountReactRestController {
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping(value ="/accounts/{id}")
	public Mono<Account> getOne(@PathVariable String id){
		return accountRepository.findById(id);
	}
	
	@PostMapping("/accounts")
	public Mono<Account> save(@RequestBody Account account){
		return accountRepository.save(account);
	}
	
	@DeleteMapping("/accounts")
	public Mono<Void> delete(@PathVariable String id){
		return accountRepository.deleteById(id);
	}
	
	@PutMapping("/accounts/{id}")
	public Mono<Account> update(@RequestBody Account account, @PathVariable String id){
		account.setId(id);
		return accountRepository.save(account);
	}
	
	@GetMapping(value ="/accounts")
	public Flux<Account> findAll(){
		return accountRepository.findAll();
	}

}

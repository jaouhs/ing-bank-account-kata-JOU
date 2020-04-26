package fr.ing.interview.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Account {
	private String id;
	private Double balance = 0.0d;
	
	@DBRef
	private Customer customer;
	
	private String accountId;

	/**
	 * Add amount to balance
	 * @param amount
	 */
	public void addAmount(Double amount) {
		this.balance += amount;
	}
}

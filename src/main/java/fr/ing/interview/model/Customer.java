package fr.ing.interview.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Customer {
	private String id;
	private String name;
	private String customerId;
	
	private List<Account> accounts = new ArrayList<Account>();
}

package fr.ing.interview.service.impl;

import org.springframework.stereotype.Service;

import fr.ing.interview.service.TransactionRule;

@Service
public class TransactionRuleImpl implements TransactionRule {
	
	final static Double MIN_AMOUNT_ALLOWED = 0.01d;
	final static Double AMOUNT_ZERO = 0.00d;

	@Override
	public boolean depositAllowed(Double amount) {
		return amount > MIN_AMOUNT_ALLOWED;
	}

	@Override
	public boolean withdrawAllowed(Double amount) {
		return amount > AMOUNT_ZERO;
	}

}

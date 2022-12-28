package dev.bank.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.model.BankTransaction;

public class BankStatementProcessor {
	
	private final List<BankTransaction> bankTransactions;
	
	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		super();
		this.bankTransactions = bankTransactions;
	}

	// 총 입출금 내역 금액 반환
	public double calculateTotalAmount() {
		double totalAmount = 0;
		for (BankTransaction bankTransaction : bankTransactions) {
			totalAmount += bankTransaction.getAmount();
		}
		return totalAmount;
	}
	
	// 특정 월에 대한 입출금 리스트 반환
	public List<BankTransaction> calculdateTotalInMonth(Month month){
		List<BankTransaction> list = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				list.add(bankTransaction);
			}
		}
		return list;
	}
	
	// 카테고리별(description 필드) 총 입출금 내역(합계) 반환
	public double calculateTotalForCategory(String category) {
		double totalAmount = 0;
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDescription() == category) {
				totalAmount += bankTransaction.getAmount();
			}

		}
		return totalAmount;
	}
	
}

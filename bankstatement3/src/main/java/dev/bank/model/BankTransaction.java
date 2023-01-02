package dev.bank.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class BankTransaction {
	private LocalDate date; // 입출금 날짜
	private double amount; // 입출금액
	private String description; // 입출금이 발생한 지점(거리처)
	
}

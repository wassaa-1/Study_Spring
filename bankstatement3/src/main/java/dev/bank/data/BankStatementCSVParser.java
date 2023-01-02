package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.bank.model.BankTransaction;

@Component("parser")
public class BankStatementCSVParser implements BankStatementParser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// 한 줄만 파싱
	public BankTransaction parseFrom(final String line) {
		String[] columns = line.split(",");
		
		LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		double amount = Double.parseDouble(columns[1]);
		String description = columns[2];
		
		return new BankTransaction(date, amount, description);
	}
	
	// 한줄씩 파싱된 데이터를 리스트에 추가 후 반환
	@Override
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList();
		
		for (String line : lines) {
			bankTransactions.add(parseFrom(line));
		}
		return bankTransactions;
	}

}

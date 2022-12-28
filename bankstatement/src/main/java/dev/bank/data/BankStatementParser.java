package dev.bank.data;

import java.util.List;

import dev.bank.model.BankTransaction;

public interface BankStatementParser {
	BankTransaction parseFrom(final String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
	
}
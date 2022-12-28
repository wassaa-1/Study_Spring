package dev.bank;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;

public class BankStatementFactory {
	public BankStatementAnalyzer createAnalyzer() {
		BankStatementParser parser = new BankStatementCSVParser();
		
		BankStatementAnalyzer analyzer = new BankStatementAnalyzer(parser);
		
		return analyzer;
	}
}

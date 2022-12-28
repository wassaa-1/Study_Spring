package dev.bank;

import java.io.IOException;

public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		
		BankStatementFactory factory = new BankStatementFactory();
		
		BankStatementAnalyzer analyzer = factory.createAnalyzer();
		
		analyzer.analyze("bank-data-simple.csv");
	}

}
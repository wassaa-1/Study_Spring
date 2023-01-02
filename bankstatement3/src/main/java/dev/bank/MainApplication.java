package dev.bank;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		
		// After Spring
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BankStatementFactory.class);
		BankStatementAnalyzer analyzer = applicationContext.getBean(BankStatementAnalyzer.class);
		
		analyzer.analyze("bank-data-simple.csv");
	}

}
package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;

@Configuration // 이 클래스가 빈 구성 정보(Bean Config)로 활용될 수 있도록 지정
@ComponentScan
public class BankStatementFactory {
	
//	@Bean // BankStatementAnalyzer 타입을 스프링 컨테이너 내부 공간에 하나의 빈으로 등록
//	public BankStatementAnalyzer createAnalyzer() {
//		
//		return new BankStatementAnalyzer(new BankStatementCSVParser());
//	}
}

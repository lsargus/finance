package br.com.lsargus.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"br.com.lsargus.finance.adapter",
		"br.com.lsargus.finance.data",
		"br.com.lsargus.finance.config",
		"br.com.lsargus.finance.service",
		"br.com.lsargus.finance.mapper",
		"br.com.lsargus.finance.repository",
		"br.com.lsargus.finance.controller"})
public class FinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceApplication.class, args);
	}

}

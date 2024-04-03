package com.test.mbb.employee;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig 
{
	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository repository) 
	{
		return args->
		{
			Employee john =new Employee("John","john.oo.com","01233", "Software", LocalDate.of(1995,1,19));
			Employee deepa =new Employee("Deepa","deepa.oo.com","01233", "Software", LocalDate.of(1999,3,29));
			repository.saveAll(List.of(john,deepa));
		};
	}
}

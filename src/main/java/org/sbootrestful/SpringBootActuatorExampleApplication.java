package org.sbootrestful;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.sbootrestful.dao.AccountRepository;
import org.sbootrestful.dao.UsernamesRepository;
import org.sbootrestful.model.Account;
import org.sbootrestful.model.Usernames;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootActuatorExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActuatorExampleApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(AccountRepository accountRepository,
			UsernamesRepository usernamesRepository) {
		return (evt) -> Arrays.asList(
				"ricksanchez,mortysmith,bethsmith,jerrysmith,summersmith,birdperson,squanchy,picklerick".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account(a,
									"password"));
							usernamesRepository.save(new Usernames(account,
									"http://example.com/login", a +"1"));
							usernamesRepository.save(new Usernames(account,
									"http://example2.com/login", "the_"+a));
						});
	}
}
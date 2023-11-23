package dz.abd.bankaccountservice;

import dz.abd.bankaccountservice.entities.BankAccount;
import dz.abd.bankaccountservice.entities.Customer;
import dz.abd.bankaccountservice.enumes.AccountType;
import dz.abd.bankaccountservice.respositories.BankAccountRepository;
import dz.abd.bankaccountservice.respositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean

	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){


		return args -> {


			Stream.of("mohamed","yasine","ahmed").forEach(c->{
				Customer customer= Customer.builder()
						.name(c)
						.build();

				customerRepository.save(customer);


			});

			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i <10 ; i++) {
					BankAccount bankAccount=BankAccount.builder().id(UUID.randomUUID().toString())
							.accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
							.balance(1000+Math.random()*9000)
							.createDate( new Date()).currency("dzd")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);

				}

			});


		};
	}

}

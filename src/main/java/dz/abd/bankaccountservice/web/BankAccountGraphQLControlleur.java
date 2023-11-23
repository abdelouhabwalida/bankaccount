package dz.abd.bankaccountservice.web;

import dz.abd.bankaccountservice.dto.BankAccountRequestDTO;
import dz.abd.bankaccountservice.dto.BankAccountRespenseDTO;
import dz.abd.bankaccountservice.entities.BankAccount;
import dz.abd.bankaccountservice.entities.Customer;
import dz.abd.bankaccountservice.respositories.BankAccountRepository;
import dz.abd.bankaccountservice.respositories.CustomerRepository;
import dz.abd.bankaccountservice.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author abdelouhab.walida
 */
@Controller
public class BankAccountGraphQLControlleur {

    private BankAccountRepository bankAccountRepository;
 private AccountService accountService;
 private CustomerRepository customerRepository;

    public BankAccountGraphQLControlleur(BankAccountRepository bankAccountRepository, AccountService accountService, CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;

        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();


    }
    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("acount %s is not found ",id)));


    }
    @MutationMapping
    public BankAccountRespenseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){

        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountRespenseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){

        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public void deleteAccount(@Argument String id){

         bankAccountRepository.deleteById(id);
    }
@QueryMapping
    public List<Customer> customers(){

        return customerRepository.findAll();
    }

}

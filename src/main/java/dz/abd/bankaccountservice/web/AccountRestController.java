package dz.abd.bankaccountservice.web;

import dz.abd.bankaccountservice.dto.BankAccountRequestDTO;
import dz.abd.bankaccountservice.dto.BankAccountRespenseDTO;
import dz.abd.bankaccountservice.entities.BankAccount;
import dz.abd.bankaccountservice.mappers.AccountMapper;
import dz.abd.bankaccountservice.respositories.BankAccountRepository;
import dz.abd.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author abdelouhab.walida
 */
@RestController

public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){

        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){

        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found ",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountRespenseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        System.out.println(requestDTO.toString());
        return accountService.addAccount(requestDTO);

    }
    @PostMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){

        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
       if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getBalance()!=null)  account.setCreateDate( new Date());
        if(bankAccount.getBalance()!=null) account.setAccountType(bankAccount.getAccountType());

        return bankAccountRepository.save(account);

    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){

     bankAccountRepository.deleteById(id);

    }
}

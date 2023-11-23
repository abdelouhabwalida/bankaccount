package dz.abd.bankaccountservice.service;

import dz.abd.bankaccountservice.dto.BankAccountRequestDTO;
import dz.abd.bankaccountservice.dto.BankAccountRespenseDTO;
import dz.abd.bankaccountservice.entities.BankAccount;
import dz.abd.bankaccountservice.mappers.AccountMapper;
import dz.abd.bankaccountservice.respositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @author abdelouhab.walida
 */

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;
    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountRespenseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        System.out.println("add account");
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createDate(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .accountType(bankAccountRequestDTO.getAccountType())
                .build();

//
//                accountMapper.fromRequestDTO(bankAccountRequestDTO);
//        System.out.println(bankAccount.toString());
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        System.out.println(saveBankAccount.toString());
        BankAccountRespenseDTO bankAccountRespenseDTO = accountMapper.fromBankAccount(saveBankAccount);

        return bankAccountRespenseDTO;
    }
    @Override
    public BankAccountRespenseDTO updateAccount(String  id,BankAccountRequestDTO bankAccountRequestDTO) {

        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createDate(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .accountType(bankAccountRequestDTO.getAccountType())
                .build();

//
//                accountMapper.fromRequestDTO(bankAccountRequestDTO);
//        System.out.println(bankAccount.toString());
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        System.out.println(saveBankAccount.toString());
        BankAccountRespenseDTO bankAccountRespenseDTO = accountMapper.fromBankAccount(saveBankAccount);

        return bankAccountRespenseDTO;
    }
}

package dz.abd.bankaccountservice.mappers;

import dz.abd.bankaccountservice.dto.BankAccountRequestDTO;
import dz.abd.bankaccountservice.dto.BankAccountRespenseDTO;
import dz.abd.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author abdelouhab.walida
 */

@Component
public class AccountMapper {


    public BankAccountRespenseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountRespenseDTO bankAccountRespenseDTO = new BankAccountRespenseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountRespenseDTO);
        return bankAccountRespenseDTO;



    }


    public BankAccount fromRequestDTO (BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO,bankAccount);
        return bankAccount;
    }
}

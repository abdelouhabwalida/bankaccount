package dz.abd.bankaccountservice.service;

import dz.abd.bankaccountservice.dto.BankAccountRequestDTO;
import dz.abd.bankaccountservice.dto.BankAccountRespenseDTO;

/**
 * @author abdelouhab.walida
 */
public interface AccountService {


    public BankAccountRespenseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountRespenseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
}

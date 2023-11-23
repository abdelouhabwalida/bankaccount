package dz.abd.bankaccountservice.dto;

import dz.abd.bankaccountservice.enumes.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author abdelouhab.walida
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountRespenseDTO {

    private  String id;
    private Date createDate;
    private Double balance;
    private String currency;
    private AccountType accountType;
}

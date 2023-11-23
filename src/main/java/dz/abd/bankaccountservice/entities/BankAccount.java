package dz.abd.bankaccountservice.entities;

import dz.abd.bankaccountservice.enumes.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author abdelouhab.walida
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {

@Id
    private  String id;
    private Date createDate;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @ManyToOne
    private Customer customer;


}

package dz.abd.bankaccountservice.entities;

import dz.abd.bankaccountservice.enumes.AccountType;
import org.springframework.data.rest.core.config.Projection;

/**
 * @author abdelouhab.walida
 */
@Projection(types = BankAccount.class , name= "p1")
public interface AccountProjection extends Projection{

    public String getId();
    public AccountType getType();
    public Double getBalance();
}

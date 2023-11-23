package dz.abd.bankaccountservice.respositories;

import dz.abd.bankaccountservice.entities.BankAccount;
import dz.abd.bankaccountservice.enumes.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author abdelouhab.walida
 */

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @RestResource(path = "/byType")
    List<BankAccount>findByAccountType(@Param("t") AccountType type);
}

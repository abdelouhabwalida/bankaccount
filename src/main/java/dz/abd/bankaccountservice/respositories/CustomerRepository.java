package dz.abd.bankaccountservice.respositories;

import dz.abd.bankaccountservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author abdelouhab.walida
 */
public interface CustomerRepository  extends JpaRepository<Customer,Long> {

}

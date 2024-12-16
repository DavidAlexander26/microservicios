package  com.synopsis.capacitacion.customer.respository;

import com.synopsis.capacitacion.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}

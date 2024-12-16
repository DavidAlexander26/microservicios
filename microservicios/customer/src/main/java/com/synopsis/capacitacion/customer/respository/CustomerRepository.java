package  com.synopsis.capacitacion.customer.respository;

import com.synopsis.capacitacion.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT update_customer(:id, :code, :name, :phone, :iban, :surname, :address)", nativeQuery = true)
    void updateCustomer(@Param("id") Long id, @Param("code") String code, @Param("name") String name,
                        @Param("phone") String phone, @Param("iban") String iban, @Param("surname") String surname,
                        @Param("address") String address);
}

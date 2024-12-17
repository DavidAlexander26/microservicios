package com.synopsis.capacitacion.customer.respository;

import com.synopsis.capacitacion.customer.entities.CustomerProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long> {

}

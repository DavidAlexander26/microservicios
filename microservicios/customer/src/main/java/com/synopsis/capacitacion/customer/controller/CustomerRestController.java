package  com.synopsis.capacitacion.customer.controller;

import com.synopsis.capacitacion.customer.entities.Customer;
import com.synopsis.capacitacion.customer.entities.CustomerProduct;
import com.synopsis.capacitacion.customer.service.ICustomerService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping()
    public List<Customer> getAll() {
        return iCustomerService.findAll();
    }
    
    @GetMapping("/{id}")
    public Object getById(@PathVariable(name = "id") long id) {
        return iCustomerService.findById(id);
    }

    @PostMapping
    public Object postCreate(@RequestBody Customer customer) {
        return iCustomerService.createCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public Object updateCustomer(@PathVariable(name = "id") Long id, @RequestBody Customer customer){
        return iCustomerService.updateCustomer(id,customer);
    }

    @PutMapping("/products/{id}")
    public Object updateProducts(@PathVariable(name = "id") Long id, @RequestBody List<CustomerProduct> products){
        return iCustomerService.updateProducts(id,products);
    }
    @DeleteMapping("/{id}")
    public Object deleteById(@PathVariable(name = "id") long id) {
        return iCustomerService.deleteById(id);
    }

}

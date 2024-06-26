package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjk.com.demo.entity.Customer;
import sjk.com.demo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}

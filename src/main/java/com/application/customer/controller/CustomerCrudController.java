package com.application.customer.controller;

import com.application.customer.model.CustomerModel;
import com.application.customer.model.CustomerUpdateModel;
import com.application.customer.response.CustomerListResponse;
import com.application.customer.response.CustomerResponse;
import com.application.customer.service.CustomerCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/customer")
public class CustomerCrudController {

    @Autowired
    private CustomerCrudService customerService;

    @PostMapping("/create")
    CustomerResponse createCustomer(@RequestBody CustomerModel customerModel) throws Exception {
        return customerService.createCustomer(customerModel);
    }

    @GetMapping("/list")
    CustomerListResponse displayAllCustomer() {
        return customerService.displayAllCustomers();
    }

    @GetMapping("/details")
    CustomerResponse displayCustomer(@RequestParam Long customerId) throws Exception {
        return customerService.displayCustomer(customerId);
    }


    @PutMapping("/update")
    CustomerResponse updateCustomer(@RequestBody CustomerUpdateModel customerUpdateModel) throws Exception {
        return customerService.updateCustomer(customerUpdateModel);
    }


    @DeleteMapping("/delete")
    String deleteCustomer(@RequestParam Long customerId) throws Exception {

        customerService.deleteCustomer(customerId);
        return "Customer deleted successfully";
    }
}

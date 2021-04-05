package com.application.customer.service;

import com.application.customer.entity.Customer;
import com.application.customer.model.CustomerModel;
import com.application.customer.model.CustomerUpdateModel;
import com.application.customer.repository.CustomerRepository;
import com.application.customer.response.CustomerListResponse;
import com.application.customer.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCrudService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerModel customerModel) throws Exception {

        if (customerModel.getName() == null || customerModel.getName().isEmpty()) {
            throw new Exception("Enter a valid name");
        }
        if (customerModel.getAddress() == null || customerModel.getAddress().isEmpty()) {
            throw new Exception("Enter a valid address");
        }

        Customer newCustomer = new Customer();
        newCustomer.setName(customerModel.getName());
        newCustomer.setAddress(customerModel.getAddress());
        newCustomer = customerRepository.save(newCustomer);

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomer(newCustomer);

        return customerResponse;

    }


    public CustomerResponse updateCustomer(CustomerUpdateModel customerUpdateModel) throws Exception {

        if (customerUpdateModel.getId() == null || customerUpdateModel.getId() == 0) {
            throw new Exception("Enter a valid customerID");
        }
        Customer updateCustomer = customerRepository.findByCustomerId(customerUpdateModel.getId());

        if (updateCustomer == null) {
            throw new Exception("No Customer exists with this ID");
        }

        if (customerUpdateModel.getName() != null && !customerUpdateModel.getName().isEmpty()) {
            updateCustomer.setName(customerUpdateModel.getName());
        }
        if (customerUpdateModel.getAddress() != null && !customerUpdateModel.getAddress().isEmpty()) {
            updateCustomer.setAddress(customerUpdateModel.getAddress());
        }
        updateCustomer = customerRepository.save(updateCustomer);

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomer(updateCustomer);

        return customerResponse;
    }


    public CustomerListResponse displayAllCustomers() {
        List<Customer> listCutomer = customerRepository.findAll();

        CustomerListResponse customerListResponse = new CustomerListResponse();
        customerListResponse.setCustomerList(listCutomer);

        return customerListResponse;

    }

    public CustomerResponse displayCustomer(Long customerId) throws Exception {

        if (customerId == null || customerId == 0) {
            throw new Exception("Enter a valid customerID");
        }

        Customer customer = customerRepository.findByCustomerId(customerId);

        if (customer == null) {
            throw new Exception("No Customer exists with this ID");
        }


        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomer(customer);

        return customerResponse;
    }

    public void deleteCustomer(Long customerId) throws Exception {
        if (customerId == null || customerId == 0) {
            throw new Exception("Enter a valid customerID");
        }

        Customer customer = customerRepository.findByCustomerId(customerId);

        if (customer == null) {
            throw new Exception("No Customer exists with this ID");
        }
        customerRepository.delete(customer);

    }


}

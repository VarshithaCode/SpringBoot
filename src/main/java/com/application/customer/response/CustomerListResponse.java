package com.application.customer.response;

import com.application.customer.entity.Customer;

import java.util.List;

public class CustomerListResponse {
    private List<Customer> customerList;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

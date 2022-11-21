package com.nagarro.customerservice.controller;

import com.nagarro.customerservice.Classes.MyItem;
import com.nagarro.customerservice.Classes.MyOrders;
import com.nagarro.customerservice.entity.Customer;
import com.nagarro.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer)
    {
        return  customerService.saveCustomer(customer);
    }

    @GetMapping("/myorders/{cid}")
    public MyOrders myItemOrders(@PathVariable("cid") Long custId)
    {
        return  customerService.getMyOrder(custId);
    }

    @GetMapping("/myitem/{cid}")
    public MyItem myOrders(@PathVariable("cid") Long custId)
    {
        return  customerService.myOrder(custId);
    }



}

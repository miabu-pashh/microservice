package com.nagarro.customerservice.service;

import com.nagarro.customerservice.Classes.Item;
import com.nagarro.customerservice.Classes.ItemDetails;
import com.nagarro.customerservice.Classes.MyItem;
import com.nagarro.customerservice.Classes.MyOrders;
import com.nagarro.customerservice.entity.Customer;
import com.nagarro.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    RestTemplate restTemplate;

    public Customer saveCustomer(Customer c)
    {
        return customerRepository.save(c);
    }

    public MyOrders getMyOrder(Long custId)
    {
        Optional<Customer> cust=customerRepository.findById(custId);
        Long pid =cust.get().getPid();
        ItemDetails item=restTemplate.getForObject("http://ITEM-DETAILS-SERVICE/itemDetails/"+pid, ItemDetails.class);

MyOrders myOrders=new MyOrders();
myOrders.setItemDetails(item);
myOrders.setCustomer(cust.get());

        return myOrders;
    }

    public MyItem myOrder(Long custId) {
        Optional<Customer> cust=customerRepository.findById(custId);
        Long pid =cust.get().getPid();
        Item item=restTemplate.getForObject("http://ITEM-SERVICE/item/"+pid, Item.class);
        MyItem myItem=new MyItem();
        myItem.setCustomer(cust.get());
        myItem.setItem(item);
        return myItem;

    }
}

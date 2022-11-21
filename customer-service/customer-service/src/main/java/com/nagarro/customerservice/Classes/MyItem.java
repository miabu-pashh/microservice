package com.nagarro.customerservice.Classes;

import com.nagarro.customerservice.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyItem {

    private Item item;
    private Customer customer;
}

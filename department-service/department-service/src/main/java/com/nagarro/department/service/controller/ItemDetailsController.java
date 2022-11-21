package com.nagarro.department.service.controller;

import com.nagarro.department.service.entity.ItemDetails;
import com.nagarro.department.service.service.ItemDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemDetails")

@Slf4j
public class ItemDetailsController {

    @Autowired
    private ItemDetailsService itemDetailsService;


    @PostMapping("/")
    public ItemDetails saveItemDetails(@RequestBody ItemDetails itemDetails){
        log.info("Inside the method of saveItemDetails inside controller");
        return itemDetailsService.saveItemDetails(itemDetails);
    }


    @GetMapping("/")
    public List<ItemDetails> findAllItemDetails(){
        return itemDetailsService.findAllItemDetails();
    }
    @GetMapping("/{id}")
    public ItemDetails findItemDetailsById(@PathVariable("id") Long ItemDetailsId){
        log.info("Inside the method of findItemDetailsById inside controller");
        return itemDetailsService.findItemDetailsById(ItemDetailsId);

    }

}

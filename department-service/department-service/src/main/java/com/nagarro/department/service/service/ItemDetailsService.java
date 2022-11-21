package com.nagarro.department.service.service;

import com.nagarro.department.service.entity.ItemDetails;
import com.nagarro.department.service.repository.ItemDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Slf4j
public class ItemDetailsService {
    @Autowired
    private ItemDetailsRepository itemDetailsRepository;


    public ItemDetails saveItemDetails(ItemDetails itemDetails) {
        log.info("Inside the method of saveItemDetails in ervice class");

        return itemDetailsRepository.save(itemDetails);
    }


    public ItemDetails findItemDetailsById(Long itemDetailsId) {
        log.info("Inside the method of findById in service class");
        return itemDetailsRepository.findItemDetailsById(itemDetailsId);

    }

    public List<ItemDetails> findAllItemDetails() {

        return itemDetailsRepository.findAll();
    }
}

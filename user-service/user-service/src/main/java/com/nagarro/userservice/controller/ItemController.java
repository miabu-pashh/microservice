package com.nagarro.userservice.controller;

import com.nagarro.userservice.VO.ResponseTemplateVo;
import com.nagarro.userservice.entity.Item;
import com.nagarro.userservice.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")

@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/")
    public Item saveItem(@RequestBody Item item){
        log.info("inside the the save Item method of Item controller class");
        return itemService.saveItem(item);
    }

//    @GetMapping("/")
//    public List<Item> findAllItem(){
//        return itemService.findAllItem();
//    }



    @GetMapping("/itemDetails/{id}")
    public ResponseTemplateVo getItemDetails(@PathVariable("id") Long itemId)
    {
        log.info("inside the the getItemDetails  method of Item controller class");

        return itemService.getItemDetails(itemId);
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") Long itemId)
    {
        return itemService.getItem(itemId);
    }

}

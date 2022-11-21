package com.nagarro.userservice.service;

import com.nagarro.userservice.VO.ItemDetails;
import com.nagarro.userservice.VO.ResponseTemplateVo;
import com.nagarro.userservice.entity.Item;
import com.nagarro.userservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Item saveItem(Item item) {
        log.info("inside the the save Item method of Item service class");
        return itemRepository.save(item);
    }

    public List<Item> findAllItem(){
        return itemRepository.findAll();
    }

    public ResponseTemplateVo getItemDetails(Long itemId)
    {
        log.info("inside the the save Item method of Item service class");

        ResponseTemplateVo vo= new ResponseTemplateVo();
        Item item= itemRepository.findByItemId(itemId);
        ItemDetails itemDetails= restTemplate.getForObject("http://ITEM-DETAILS-SERVICE/itemDetails/"+ item.getItemDetailsId(),ItemDetails.class);
        vo.setItem(item);
        vo.setItemDetails(itemDetails);
        return vo;
    }

    public Item getItem(Long itemId) {
        return itemRepository.findByItemId(itemId);
    }
}

package com.nagarro.department.service.repository;

import com.nagarro.department.service.entity.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDetailsRepository extends JpaRepository<ItemDetails,Long> {

    ItemDetails findItemDetailsById(Long itemDetailsId);

//    List<ItemDetails> findAllItemDetails();
}

package com.nagarro.userservice.VO;

import com.nagarro.userservice.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {

    private Item item;
    private ItemDetails itemDetails;


}

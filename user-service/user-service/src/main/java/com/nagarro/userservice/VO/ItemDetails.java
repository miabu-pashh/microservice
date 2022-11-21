package com.nagarro.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetails {
    private Long id;
    private String name;
    private String design;
    private int price;
    private String size;
}

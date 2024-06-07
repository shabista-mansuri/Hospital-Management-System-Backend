package com.JeevanDanHospitals.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InventoryDto {

    private long id;
    private String equipment;
    private Long issuedQuantity;
    private String status;
    private Long unitPrice;

}

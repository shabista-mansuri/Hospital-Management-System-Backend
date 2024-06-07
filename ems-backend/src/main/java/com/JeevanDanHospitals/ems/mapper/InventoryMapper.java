package com.JeevanDanHospitals.ems.mapper;

import com.JeevanDanHospitals.ems.dto.InventoryDto;
import com.JeevanDanHospitals.ems.dto.PatientDto;
import com.JeevanDanHospitals.ems.entity.Inventory;
import com.JeevanDanHospitals.ems.entity.Patient;

public class InventoryMapper {

    public static InventoryDto mapToInventoryDto(Inventory inventory){
        return new InventoryDto(
                inventory.getId(),
                inventory.getEquipment(),
                inventory.getIssuedQuantity(),
                inventory.getStatus(),
                inventory.getUnitPrice()
        );

    }

    public static Inventory mapToInventory(InventoryDto inventoryDto){
        return new Inventory(

                inventoryDto.getId(),
                inventoryDto.getEquipment(),
                inventoryDto.getIssuedQuantity(),
                inventoryDto.getStatus(),
                inventoryDto.getUnitPrice()
        );

    }


}

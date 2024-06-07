package com.JeevanDanHospitals.ems.service;

import com.JeevanDanHospitals.ems.dto.InventoryDto;
import com.JeevanDanHospitals.ems.dto.PatientDto;

import java.util.List;

public interface InventoryService {

    InventoryDto createInventory (InventoryDto inventoryDto);

    InventoryDto getInventoryByName (String equipment);

    List<InventoryDto> getAllInventory();

    InventoryDto updateInventory(String equipmentName,  InventoryDto updatedInventory );

    Void deleteInventory(String equipment);





}

package com.JeevanDanHospitals.ems.service.impl;

import com.JeevanDanHospitals.ems.dto.InventoryDto;
import com.JeevanDanHospitals.ems.entity.Inventory;
import com.JeevanDanHospitals.ems.exception.ResourceNotFoundException;
import com.JeevanDanHospitals.ems.mapper.InventoryMapper;
import com.JeevanDanHospitals.ems.repository.InventoryRepository;
import com.JeevanDanHospitals.ems.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;
    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {
        Inventory inventory = InventoryMapper.mapToInventory(inventoryDto);
        Inventory savedInventory = inventoryRepository.save(inventory);
        return InventoryMapper.mapToInventoryDto(savedInventory);
    }

    @Override
    public InventoryDto getInventoryByName(String equipment) {
        Inventory inventory = inventoryRepository.findByEquipment(equipment)
                .orElseThrow(() -> new ResourceNotFoundException(" Equipment does not exist with provided name : "+ equipment));
        return InventoryMapper.mapToInventoryDto(inventory);
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        List<Inventory> inventory = inventoryRepository.findAll();

        return inventory.stream().map((inventory1 -> InventoryMapper.mapToInventoryDto(inventory1))).collect(Collectors.toList());
    }

    @Override
    public InventoryDto updateInventory(String equipmentName, InventoryDto updatedInventory) {
       Inventory inventory = inventoryRepository.findByEquipment(equipmentName).orElseThrow(
               () -> new ResourceNotFoundException("Not found")
       );
       inventory.setEquipment(updatedInventory.getEquipment());
       inventory.setIssuedQuantity(updatedInventory.getIssuedQuantity());
       inventory.setStatus(updatedInventory.getStatus());
       inventory.setUnitPrice(updatedInventory.getUnitPrice());

       Inventory updatedInventoryObj = inventoryRepository.save(inventory);
       return InventoryMapper.mapToInventoryDto(updatedInventoryObj);

    }

    @Override
    public Void deleteInventory(String equipment) {

        Inventory inventory = inventoryRepository.findByEquipment(equipment).orElseThrow(
                () -> new ResourceNotFoundException("Equipment does not exist")
        );
        inventoryRepository.deleteById(inventory.getId());
        return null;
    }
}

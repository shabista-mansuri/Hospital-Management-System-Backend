package com.JeevanDanHospitals.ems.controller;

import com.JeevanDanHospitals.ems.dto.InventoryDto;
import com.JeevanDanHospitals.ems.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private InventoryService inventoryService;
    @PostMapping
    //Build Add Inventory REST API
    public ResponseEntity<InventoryDto> createInventory(@RequestBody InventoryDto inventoryDto){

        InventoryDto savedInventory = inventoryService.createInventory(inventoryDto);
        return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
    }

    //Build get Inventory REST API

    @GetMapping("/{equipment}")
    public ResponseEntity<InventoryDto> getInventoryByEquipment(@PathVariable("equipment") String equipment){

        InventoryDto inventoryDto = inventoryService.getInventoryByName(equipment);
        return ResponseEntity.ok(inventoryDto);
    }

    // Build get ALL Inventory REST API
    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAllInventory(){
        List<InventoryDto> inventory = inventoryService.getAllInventory();
        return ResponseEntity.ok(inventory);

    }

    //Build update Inventory REST API
    @PutMapping("/{equipment}")
    public ResponseEntity<InventoryDto> updateInventory(@PathVariable("equipment") String equipment, @RequestBody InventoryDto updatedInventory){
        InventoryDto inventoryDto = inventoryService.updateInventory(equipment, updatedInventory);
        return ResponseEntity.ok(inventoryDto);
    }

    //Build Delete Inventory REST API

    @DeleteMapping("{equipment}")
    public ResponseEntity<String> deleteInventory(@PathVariable("equipment") String equipment){
        inventoryService.deleteInventory(equipment);
        return ResponseEntity.ok(" Entry id Deleted");
    }

}

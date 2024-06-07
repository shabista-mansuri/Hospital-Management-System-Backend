package com.JeevanDanHospitals.ems.repository;

import com.JeevanDanHospitals.ems.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InventoryRepository  extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByEquipment(String equipment);

    void deleteByEquipment(String equipment);
}

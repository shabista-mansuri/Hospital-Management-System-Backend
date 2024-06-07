package com.JeevanDanHospitals.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "Inv" )

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Equipment")
    private String equipment;
    @Column(name = "Issued_Quantity")
    private Long issuedQuantity;
    @Column(name = "Status")
    private String status;
    @Column(name = "Unit_Price")
    private Long unitPrice;


}

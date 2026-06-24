package com.musa.tenent.model;

import java.math.BigDecimal;

import com.musa.tenent.domain.UnitStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "units")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Unit {

    // This is the rentable Space inside property
    // in a 4 Bedroom House, Bedroom 1, Bedroom 2, Kitchen, and Living Room are
    // Units

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitNumber;

    private BigDecimal rentAmount;

    @Enumerated(EnumType.STRING)
    private UnitStatus status;

    private String description;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

}

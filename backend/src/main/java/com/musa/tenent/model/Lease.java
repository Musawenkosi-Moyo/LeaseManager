package com.musa.tenent.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.musa.tenent.domain.LeaseStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "leases")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Lease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal monthlyRent;

    private BigDecimal securityDeposit;

    @Enumerated(EnumType.STRING)
    private LeaseStatus status;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    // One Leasse can have many Payments
    @OneToMany(mappedBy = "lease", cascade = CascadeType.ALL)
    private List<Payment> payments;

}

package com.project.loan.Entity;

import jakarta.persistence.*;
import jdk.jfr.Percentage;
import lombok.*;

import java.math.BigDecimal;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private Long accountId;
    private BigDecimal sanctionedAmount;
    private BigDecimal estimatedAmount;
}


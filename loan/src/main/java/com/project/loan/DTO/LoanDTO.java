package com.project.loan.DTO;

import com.project.loan.Entity.Loan;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class LoanDTO {
    private Long LoanId;
    private Long accountId;
    private BigDecimal sanctionedAmount;
}

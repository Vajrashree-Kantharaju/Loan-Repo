package com.project.loan.Controller;

import com.project.loan.Service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/loan")
public class LoanController {
    private final LoanService loanService;
    public LoanController(LoanService loanService){
    this.loanService=loanService;
    }
    @GetMapping("/{id}/loan-calculation")
    public ResponseEntity<Double> getLoanCalculation(@PathVariable Long id){
        return ResponseEntity.ok(loanService.calculateLoanAmount(id));
    }


}

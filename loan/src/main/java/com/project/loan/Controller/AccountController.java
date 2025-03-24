package com.project.loan.Controller;

import com.project.loan.Entity.Account;
import com.project.loan.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/allAccounts")
    public List<Account> allAccountDetails() {
        return accountService.allAccountDetails();
    }
    @PostMapping("/createAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return ResponseEntity.ok(accountService.createAccount(account));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id){
        Optional<Account> account=accountService.getAccountDetails(id);
        return account.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());

    }
    @DeleteMapping("/deleteAccount")
    public void deleteAccount(@RequestParam Long accountId){
        accountService.deleteAccount(accountId);
    }

}

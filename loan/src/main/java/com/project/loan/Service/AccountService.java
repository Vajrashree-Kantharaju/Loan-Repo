package com.project.loan.Service;
import com.project.loan.Entity.Account;
import com.project.loan.Repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    public AccountService (AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    public List<Account> allAccountDetails(){
        return accountRepository.findAll();
    }
    public Optional<Account> getAccountDetails(Long accountId){
        return accountRepository.findById(accountId);
    }
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
    public void deleteAccount(Long accountId){
        accountRepository.deleteById(accountId);
    }

}

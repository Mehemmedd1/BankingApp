package com.Backend.BankingApp.Controller;

import com.Backend.BankingApp.Dto.AccountDto;
import com.Backend.BankingApp.Service.AccountService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);

    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
        double amount =request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);

    }
    @GetMapping()
    public ResponseEntity<List<AccountDto>> getAllAcoounts(){
        List<AccountDto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully");
    }
}

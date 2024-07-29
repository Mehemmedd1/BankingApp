package com.Backend.BankingApp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}

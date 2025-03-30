package com.gerald.accounts.controller;

import com.gerald.accounts.dto.CustomerDto;
import com.gerald.accounts.service.AccountsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountsController {
    private final AccountsService accountsService;


    @PostMapping("/create")
    public ResponseEntity<CustomerDto> save(@Valid @RequestBody CustomerDto customerDto) {
        var accountCreated = accountsService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountCreated);

    }

}

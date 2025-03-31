package com.gerald.accounts.controller;

import com.gerald.accounts.dto.CustomerDto;
import com.gerald.accounts.dto.ResponseDto;
import com.gerald.accounts.service.AccountsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.gerald.accounts.AccountsConstants.AccountsConstants.MESSAGE_200;
import static com.gerald.accounts.AccountsConstants.AccountsConstants.MESSAGE_201;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountsController {
    private final AccountsService accountsService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> save(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED,MESSAGE_201));

    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody CustomerDto customerDto, @PathVariable String customerId) {
        accountsService.updateAccount(customerDto, customerId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,MESSAGE_200));
    }

}

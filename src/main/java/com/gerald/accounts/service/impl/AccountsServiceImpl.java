package com.gerald.accounts.service.impl;

import com.gerald.accounts.dto.CustomerDto;
import com.gerald.accounts.entity.Accounts;
import com.gerald.accounts.entity.Customers;
import com.gerald.accounts.exception.CustomerAlreadyExistsException;
import com.gerald.accounts.mappers.Mapper;
import com.gerald.accounts.repository.AccountsRepository;
import com.gerald.accounts.repository.CustomerRepository;
import com.gerald.accounts.service.AccountsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import static com.gerald.accounts.AccountsConstants.AccountsConstants.ADDRESS;
import static com.gerald.accounts.AccountsConstants.AccountsConstants.CURRENT_ACCOUNT;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {
    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;
    private final Mapper mapper;

    @Override
    @Transactional
    public void createAccount(CustomerDto customerDto) {
        log.info("Creating account {}", customerDto);

        Optional<Customers> existingMobileNumber = customerRepository.findByMobileNumber(customerDto.mobileNumber());
        Optional<Customers> existingEmail = customerRepository.findByEmail(customerDto.email());
        if (existingMobileNumber.isPresent() || existingEmail.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists" + customerDto.mobileNumber() + " " + customerDto.email());
        }
        else {
            var newCustomer = mapper.mapToCustomerEntity(customerDto);
            var newAccount = createNewAccount(newCustomer);

            customerRepository.save(newCustomer);
            accountsRepository.save(newAccount);
        }
    }

    private Accounts createNewAccount(Customers customer) {
        var accounts = new Accounts();
        long accNumber = 1000000000L + new Random().nextInt(900000000);

        accounts.setAccountNumber(String.valueOf(accNumber));
        accounts.setAccountType(CURRENT_ACCOUNT);
        accounts.setBranchAddress(ADDRESS);
        accounts.setCustomers(customer);
        accounts.setCreatedAt(LocalDateTime.now());
        accounts.setCreatedBy("Gerald");

        return accounts;
    }

}

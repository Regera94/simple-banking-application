package com.gerald.accounts.service;

import com.gerald.accounts.dto.AccountsDto;
import com.gerald.accounts.dto.CustomerDto;

public interface AccountsService {

      CustomerDto createAccount(CustomerDto customerDto);
}

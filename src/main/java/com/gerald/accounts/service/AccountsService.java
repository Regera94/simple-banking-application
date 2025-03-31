package com.gerald.accounts.service;

import com.gerald.accounts.dto.CustomerDto;

public interface AccountsService {

      void createAccount(CustomerDto customerDto);
      void updateAccount(CustomerDto customerDto, String customerId);

}

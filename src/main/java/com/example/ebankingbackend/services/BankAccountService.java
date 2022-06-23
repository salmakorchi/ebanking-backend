package com.example.ebankingbackend.services;

import com.example.ebankingbackend.dtos.CustomerDTO;
import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.CurrentAccount;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.entities.SavingAccount;
import com.example.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.example.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.example.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;

    List<CustomerDTO> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId,double amount,String description) throws  BankAccountNotFoundException;
    void transfer(String accountIdSouce,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
    List<BankAccount> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    // mise a jour Client
    CustomerDTO UpdateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);
}

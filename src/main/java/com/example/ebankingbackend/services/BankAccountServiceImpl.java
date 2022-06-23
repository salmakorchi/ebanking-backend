package com.example.ebankingbackend.services;

import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.CurrentAccount;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.entities.SavingAccount;
import com.example.ebankingbackend.exceptions.CustomerNotFoundException;
import com.example.ebankingbackend.repositories.AccountOperationRepository;
import com.example.ebankingbackend.repositories.BankAccountRepository;
import com.example.ebankingbackend.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional // make sure you're using the spring transactional method not javax

//instead of Autowired we use :
@AllArgsConstructor

// instead of Logger log = LoggerFactory.getLogger(this.getClass().getName());
//we can use lombok annotation :
@Slf4j

public class BankAccountServiceImpl implements  BankAccountService{

  //  @Autowired // DEPENDENCIES INJECTION (best to use constructors instead )
     private CustomerRepository customerRepository;

     private BankAccountRepository bankAccountRepository;

     private AccountOperationRepository accountOperationRepository;

    /* // OR instead of Autowired we use  :
    public BankAccountServiceImpl(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository, AccountOperationRepository accountOperationRepository) {
        this.customerRepository = customerRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.accountOperationRepository = accountOperationRepository;
    }*/



    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving a new Customer");
        Customer savedCustomer= customerRepository.save(customer);

        return savedCustomer;
    }

    @Override
    public BankAccount saveBankAccount(double initialBalance, String type, Long customerId) throws CustomerNotFoundException {
       BankAccount bankAccount;
       Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer==null){
            throw new CustomerNotFoundException("Customer not found");

        }
       if(type.equals("current")){
           bankAccount= new CurrentAccount();

       }else{
           bankAccount= new SavingAccount();
        }
       bankAccount.setId(UUID.randomUUID().toString());
       bankAccount.setCreatedAt(new Date());
       bankAccount.setBalance(initialBalance);
       bankAccount.setCustomer(customer);
       bankAccount.

        return null;
    }

    @Override
    public List<Customer> listCustomer() {
        return null;
    }

    @Override
    public BankAccount getBankAccount(String accountId) {
        return null;
    }

    @Override
    public void debit(String accountId, double amount, String description) {

    }

    @Override
    public void credit(String accountId, double amount, String description) {

    }

    @Override
    public void transfer(String accountIdSouce, String accountIdDestination, double amount) {

    }
}

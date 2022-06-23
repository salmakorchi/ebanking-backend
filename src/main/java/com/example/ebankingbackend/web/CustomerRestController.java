package com.example.ebankingbackend.web;

import com.example.ebankingbackend.dtos.CustomerDTO;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.exceptions.CustomerNotFoundException;
import com.example.ebankingbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return  bankAccountService.listCustomers();
    }
    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name="id")Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }
    @PostMapping("/customers")
    public  CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        //request body is meant to tell spring that customer data will be taken in json format

       return bankAccountService.saveCustomer(customerDTO);

    }
    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.UpdateCustomer(customerDTO);

    }
    @DeleteMapping("/customers/{id}")
    public void  deleteCustomer(@PathVariable Long id){
        bankAccountService.deleteCustomer(id);
    }
}

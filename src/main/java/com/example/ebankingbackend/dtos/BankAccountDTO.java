package com.example.ebankingbackend.dtos;
import com.example.ebankingbackend.entities.AccountOperation;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public  class BankAccountDTO {
    private String type;
}


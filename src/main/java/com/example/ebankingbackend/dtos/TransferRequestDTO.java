package com.example.ebankingbackend.dtos;

import lombok.Data;

@Data
public class TransferRequestDTO {
    private String accountSource , accountDestination;
    private double amount;
    private String description;
}

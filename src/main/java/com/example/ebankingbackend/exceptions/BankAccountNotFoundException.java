package com.example.ebankingbackend.exceptions;

public class BankAccountNotFoundException extends Exception {
    public BankAccountNotFoundException(String Message) {
        super(Message);
    }
}

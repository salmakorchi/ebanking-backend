package com.example.ebankingbackend.exceptions;

public class BalanceNotSufficientException extends Exception {
    public BalanceNotSufficientException(String Message) {
        super(Message);
    }
}

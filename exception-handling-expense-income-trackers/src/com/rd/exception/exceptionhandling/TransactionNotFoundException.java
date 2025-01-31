package com.rd.exception.exceptionhandling;

public class TransactionNotFoundException  extends RuntimeException {
    public TransactionNotFoundException(String message) {
        super(message);
    }
}

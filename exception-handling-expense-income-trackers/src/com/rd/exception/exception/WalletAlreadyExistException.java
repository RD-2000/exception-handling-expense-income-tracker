package com.rd.exception.exception;

public class WalletAlreadyExistException extends RuntimeException {
public WalletAlreadyExistException(String message){
    super(message);
}
}
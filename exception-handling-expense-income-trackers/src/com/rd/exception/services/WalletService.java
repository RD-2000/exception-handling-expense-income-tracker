package com.rd.exception.services;


import com.rd.exception.model.Wallet;
import com.rd.exception.repository.WalletRepository;
import com.rd.exception.exceptionhandling.WalletNotFoundException;

public class WalletService {
    private WalletRepository walletRepository;

    public WalletService() {
        this.walletRepository = walletRepository;
    }

    public void createWallet(Wallet wallet) {
        try {
            walletRepository.saveWallet(wallet);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Wallet getWallet() {
        try {
            int id = 0;
            return walletRepository.getWallet(id);
        } catch (WalletNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void viewAllWallets() {
        try {
            walletRepository.viewAllWallets();
        } catch (WalletNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void createWallet(String name, double balance) {
    }
}


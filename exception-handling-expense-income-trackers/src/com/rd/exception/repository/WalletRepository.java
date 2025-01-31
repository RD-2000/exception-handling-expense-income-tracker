package com.rd.exception.repository;


import com.rd.exception.model.Wallet;
import com.rd.exception.exceptionhandling.WalletNotFoundException;

import java.util.HashMap;

public class WalletRepository {
    private HashMap<Integer, Wallet> wallets = new HashMap<>();
    private static int walletIdCounter = 1;

    // Save a wallet to the repository
    public void saveWallet(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet cannot be null");
        }

        wallets.put(wallet.getId(), wallet);
    }

    // Get a wallet by its ID
    public Wallet getWallet(int id) {
        Wallet wallet = wallets.get(id);
        if (wallet == null) {
            throw new WalletNotFoundException("Wallet with ID " + id + " not found");
        }
        return wallet;
    }

    // View all wallets
    public void viewAllWallets() {
        if (wallets.isEmpty()) {
            throw new WalletNotFoundException("No wallets found in the repository");
        }

        for (Wallet wallet : wallets.values()) {
            System.out.println("ID: " + wallet.getId() + ", Name: " + wallet.getName() + ", Balance: " + wallet.getBalance());
        }
    }
}


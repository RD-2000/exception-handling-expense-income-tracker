package com.rd.exception.repository;


import com.rd.exception.model.Transaction;
import com.rd.exception.exceptionhandling.TransactionNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;

    public class TransactionRepository {
        private HashMap<Integer, ArrayList<Transaction>> transactions = new HashMap<>();

        // Add a transaction to the repository
        public void addTransaction(Transaction transaction) {
            if (transaction == null) {
                throw new IllegalArgumentException("Transaction cannot be null");
            }

            transactions.putIfAbsent(transaction.getWalletId(), new ArrayList<>());
            transactions.get(transaction.getWalletId()).add(transaction);
        }

        // Get all transactions for a specific wallet
        public ArrayList<Transaction> getTransactions(int walletId) {
            ArrayList<Transaction> transactionList = transactions.get(walletId);
            if (transactionList == null || transactionList.isEmpty()) {
                throw new TransactionNotFoundException("No transactions found for wallet ID: " + walletId);
            }
            return transactionList;
        }
    }



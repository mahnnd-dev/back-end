package dev.m.service;

import dev.m.model.Transaction;
import dev.m.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Page<Transaction> getTransactions(int page, int limit) {
        return transactionRepository.findAll(PageRequest.of(page - 1, limit));
    }

    public Transaction addTransaction(Transaction transaction) {
        transaction.setId(UUID.randomUUID().toString());
        return transactionRepository.save(transaction);
    }
}

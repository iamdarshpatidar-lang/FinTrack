package com.example.fintrack.service;

import com.example.fintrack.dto.TransactionRequest;
import com.example.fintrack.entity.Transactions;
import com.example.fintrack.entity.User;
import com.example.fintrack.repository.TransactionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsService {

    private final TransactionsRepository transactionsRepository;

    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Transactional
    public Transactions saveTransaction(Transactions transaction) {
        return transactionsRepository.save(transaction);
    }

    public List<Transactions> findTransactionsByUser(Long userId) {
        return transactionsRepository.findByUser_Id(userId);
    }

    public Optional<Transactions> findTransactionByIdAndUser(
            Long transactionId, Long userId) {

        return transactionsRepository.findByIdAndUser_Id(
                transactionId, userId);
    }

    @Transactional
    public void deleteTransaction(Long transactionId, Long userId) {
        transactionsRepository.deleteByIdAndUser_Id(
                transactionId, userId);
    }

    private void validateTransaction(TransactionRequest request) {

        if (request == null) {
            throw new IllegalArgumentException("Transaction data is required");
        }

        if (request.getAmount() == null ||
                request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero");
        }

        if (request.getDescription() == null ||
                request.getDescription().isBlank()) {
            throw new IllegalArgumentException(
                    "Description cannot be empty");
        }

        if (request.getCategory() == null ||
                request.getCategory().isBlank()) {
            throw new IllegalArgumentException(
                    "Category cannot be empty");
        }

        if (request.getType() == null) {
            throw new IllegalArgumentException(
                    "Transaction type is required");
        }

        if (request.getDate() == null) {
            throw new IllegalArgumentException(
                    "Transaction date is required");
        }
    }

    @Transactional
    public Transactions createTransaction(
            TransactionRequest request, User user) {

        validateTransaction(request);

        if (user == null) {
            throw new IllegalArgumentException("User is required");
        }

        Transactions transaction = new Transactions();

        transaction.setUser(user);
        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());
        transaction.setCategory(request.getCategory());
        transaction.setDescription(request.getDescription());
        transaction.setTransactionDate(request.getDate());

        return transactionsRepository.save(transaction);
    }

}
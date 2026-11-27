package com.example.fintrack.repository;

import com.example.fintrack.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionsRepository extends JpaRepository<Transactions, Long>
{
    List<Transactions> findByUser_Id(Long userId);

    Optional<Transactions> findByIdAndUser_Id(Long transactionId, Long userId);

    void deleteByIdAndUser_Id(Long transactionId, Long userId);

}

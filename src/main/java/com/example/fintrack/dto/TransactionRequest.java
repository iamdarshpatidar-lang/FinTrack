package com.example.fintrack.dto;

import com.example.fintrack.entity.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRequest {

    private BigDecimal amount;
    private String description;
    private String category;
    private TransactionType type;
    private LocalDate date;

    // Generate getters and setters for all five fields.

    public TransactionRequest(BigDecimal amount, String description, String category, TransactionType type, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.type = type;
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
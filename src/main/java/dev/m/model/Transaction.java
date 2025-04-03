package dev.m.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Transaction {
    @Id
    private String id;
    private double amount;
    private String category;
    private String type; // "income" hoặc "expense"
    private LocalDate date;
    private String note;
}
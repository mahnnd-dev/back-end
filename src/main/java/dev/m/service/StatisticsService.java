package dev.m.service;

import dev.m.model.Transaction;
import dev.m.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Map<String, Object> getStats(String filter) {
        LocalDate startDate;
        LocalDate endDate = LocalDate.now();

        switch (filter) {
            case "week":
                startDate = endDate.minusWeeks(1);
                break;
            case "year":
                startDate = endDate.minusYears(1);
                break;
            case "month":
            default:
                startDate = endDate.minusMonths(1);
                break;
        }

        List<Transaction> transactions = transactionRepository.findByDateBetween(startDate, endDate);
        double income = 0;
        double expense = 0;
        Map<String, Double> categoryTotals = new HashMap<>();

        for (Transaction t : transactions) {
            if ("income".equals(t.getType())) {
                income += t.getAmount();
            } else {
                expense += t.getAmount();
            }
            categoryTotals.merge(t.getCategory(), t.getAmount(), Double::sum);
        }

        double totalExpense = expense;
        List<Map<String, Object>> categories = categoryTotals.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> cat = new HashMap<>();
                    cat.put("name", entry.getKey());
                    cat.put("percentage", (entry.getValue() / totalExpense) * 100);
                    return cat;
                })
                .collect(Collectors.toList());

        Map<String, Object> stats = new HashMap<>();
        stats.put("income", income);
        stats.put("expense", expense);
        stats.put("balance", income - expense);
        stats.put("categories", categories);

        return stats;
    }
}
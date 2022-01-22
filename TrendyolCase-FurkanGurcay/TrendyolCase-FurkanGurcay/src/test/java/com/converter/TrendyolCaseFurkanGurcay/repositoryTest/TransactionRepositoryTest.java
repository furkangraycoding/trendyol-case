package com.converter.TrendyolCaseFurkanGurcay.repositoryTest;


import com.converter.TrendyolCaseFurkanGurcay.model.Transaction;
import com.converter.TrendyolCaseFurkanGurcay.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "jdbc:mysql://localhost:3306/trendyol?characterEncoding=UTF8"
})
public class TransactionRepositoryTest {
    @Autowired
    TransactionRepository transactionRepository;

    @Test
    public void should_find_no_transaction_if_repository_is_empty() {
        List<Transaction> transactions = transactionRepository.findAll();

        assertTrue(((List<Transaction>) transactions).isEmpty());
    }
}

package com.java.javaplayground.data.transaction.required;

import com.java.javaplayground.data.transaction.TransactionEntity;
import com.java.javaplayground.data.transaction.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RequiredSeperatedService {
    private final TransactionRepository transactionRepository;

    public RequiredSeperatedService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public void save(boolean exception) {
        System.out.println("RequiredSeperatedService.save");
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setName(UUID.randomUUID().toString().substring(0, 8));
        transactionEntity.setDescription("RequiredSeperatedService.save에 의해 저장됨");

        transactionRepository.save(transactionEntity);

        if (exception) {
            throw new IllegalArgumentException("Exception For Rollback");
        }
    }

    public void saveSeperatedCheckedException(boolean exception) throws Exception {
        System.out.println("RequiredSeperatedService.saveSeperatedCheckedException");
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setName(UUID.randomUUID().toString().substring(0, 8));
        transactionEntity.setDescription("RequiredSeperatedService.saveSeperatedCheckedException에 의해 저장됨");

        transactionRepository.save(transactionEntity);
        if (exception) {
            throw new Exception("Exception For Rollback");
        }
    }
}

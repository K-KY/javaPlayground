package com.java.javaplayground.data.transaction.required;

import com.java.javaplayground.data.transaction.TransactionEntity;
import com.java.javaplayground.data.transaction.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RequiredService {
    private final TransactionRepository repository;
    private final RequiredSeperatedService seperatedService;
    public RequiredService(TransactionRepository repository, RequiredSeperatedService seperatedService) {
        this.repository = repository;
        this.seperatedService = seperatedService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(boolean exception, boolean childException, boolean seperatedException) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setName(UUID.randomUUID().toString().substring(0, 8));
        transactionEntity.setDescription("RequiredService.save에 의해 저장됨");

        repository.save(transactionEntity);
        saveChild(childException);
        seperatedService.save(seperatedException);
        if (exception) {
            throw new IllegalArgumentException("Exception For Rollback");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveCheckedException(boolean exception, boolean seperatedException, boolean seperatedUncheck) throws Exception {
        System.out.println("RequiredService.saveCheckedException");
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setName(UUID.randomUUID().toString().substring(0, 8));
        transactionEntity.setDescription("RequiredService.saveCheckedException에 의해 저장됨");
        repository.save(transactionEntity);
        seperatedService.saveSeperatedCheckedException(seperatedException);
        seperatedService.save(seperatedUncheck);
        if (exception) {
            throw new Exception("Exception For Rollback");
        }
    }

    public void saveChild(boolean exception) {
        System.out.println("RequiredService.saveChild");
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setName(UUID.randomUUID().toString().substring(0, 8));
        transactionEntity.setDescription("RequiredService.saveChild 의해 저장됨");

        repository.save(transactionEntity);
        if (exception) {
            throw new IllegalArgumentException("Exception For Rollback");
        }
    }

    public List<TransactionEntity> getAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}

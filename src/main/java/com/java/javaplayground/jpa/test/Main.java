package com.java.javaplayground.jpa.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Main main = new Main();
        try {
//            Test test = new Test("John2", "john@gmail.com", 20, "Sample description");
//            main.save(em, transaction, test);

            transaction.begin();
            Test aNative = main.findNative(em, 1L);
            System.out.println("aNative = " + aNative);

            aNative.setAge(222);

            TestDto dto = main.findDto(em, 2L);
            System.out.println("dto = " + dto);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    public void save(EntityManager em, EntityTransaction tx, Test test) {
        try {
            tx.begin();
            em.persist(test);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    public Test findNative(EntityManager em, Long id) {
        try {
            Test test = (Test) em.createNativeQuery("SELECT * FROM Test WHERE id = :id", Test.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return test;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public TestDto findDto(EntityManager em, Long id) {
        try {
            TestDto testDto
                    = (TestDto) em.createNativeQuery("SELECT id, name, email, age FROM Test WHERE id = :id", TestDto.class)
                    .setParameter("id", id)
                    .getSingleResult();

            return testDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

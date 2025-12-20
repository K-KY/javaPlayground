package com.java.javaplayground.jpa.ch2;

import com.java.javaplayground.jpa.ch2.entity.Sample;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        //엔티티 메니저 팩토리 생성 -> 애플리케이션 실행중 딱 한번
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

        //엔티티 매니저 생성 -> 쓰레드간 공유 금지, 재사용 금지
        EntityManager entityManager = emf.createEntityManager();

        //트랜잭션 획득
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Sample sample = new Sample("ky", 12345,"male");
            entityManager.persist(sample);
            System.out.println("sample = " + sample);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }
}

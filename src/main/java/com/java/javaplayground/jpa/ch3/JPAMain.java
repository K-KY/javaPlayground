package com.java.javaplayground.jpa.ch3;

import com.java.javaplayground.jpa.ch2.entity.Sample;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Sample sample = new Sample();
            sample.setName("Sample");
            sample.setAge(9876);
            em.persist(sample);//영속성 컨텍스트 등록 sample이 영속성 엔티티가 되는거
            em.persist(sample);// 아무일도 안일어남
            em.detach(sample);// 영속성 컨텍스트에서 sample 제거
            //em.persist(sample);//persist에외 남
            sample.setName("Sample2");
            Sample merge = em.merge(sample);//merge는 새로운 객체를 반환함 원래의 sample과 관련 없음
            transaction.commit();//최종 변경된 Sample2가 저장됨
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

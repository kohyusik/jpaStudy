package com.jason.ch04;

import com.jason.ch02.AgeCalculator;
import com.jason.ch02.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author : Yusik
 * @version : 1.0
 * @date : 2018-10-28
 * @description :
 */
public class japMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            generateKey(em);
            tx.commit();


        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();




    }

    private static void generateKey(EntityManager em) {

        com.jason.ch04.Member[] memberArr = new com.jason.ch04.Member[100];
        
        for (int i = 0; i < 5; i++) {

            com.jason.ch04.Member member = new com.jason.ch04.Member();
            member.setName("koh");
            member.setAge(29 + i);

            System.out.println("member.id : " + member.getId());
            em.persist(member);
            System.out.println("member.id : " + member.getId());

            memberArr[i] = member;

        }

        // JPQL
//        em.createQuery("DELETE FROM Member e").executeUpdate();
        // SQL
//        em.createNativeQuery("TRUNCATE TABLE MEMBER").executeUpdate();


    }

}

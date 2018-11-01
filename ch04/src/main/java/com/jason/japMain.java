package com.jason;

import com.jason.entity.Item;
import com.jason.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author : Yusik
 * @version : 1.0
 * @date : 2018-10-28
 * @description :
 */
public class japMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-ch04");
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

        int memberSize = 5;
        Member[] memberArr = new Member[memberSize];
        
        for (int i = 0; i < memberSize; i++) {

            Member member = new Member();
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
    
        int itemSize = 5;
        Item[] itemArr = new Item[itemSize];
    
        for (int i = 0; i < memberSize; i++) {
        
            Item item = new Item();
            item.setName("item");
            item.setPrice(30 * i);
        
            System.out.println(">>>>>> item.id : " + item.getId());
            em.persist(item);
            System.out.println(">>>>>> item.id : " + item.getId());
    
            itemArr[i] = item;
        
        }


    }

}

package com.jason;

import com.jason.entity.Locker;
import com.jason.entity.Member;
import com.jason.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("jpa-ch06");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        /*
        *  One-to-many unidirectional
        * */
        try {

//            tx.begin();
//            unidirectional(em);
//            tx.commit();
    
            tx.begin();
            oneToOne(em);
            tx.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }
    
    private static void oneToOne(EntityManager em) {
        Member member1 = new Member("yusik");
        Member member2 = new Member("jason");
    
    
        Locker locker = new Locker("no-112");
    
        member1.setLocker(locker);
        member2.setLocker(locker);
    
        em.persist(locker);
        em.persist(member1);
        em.persist(member2);
        
        member2.setName("moozy");
    
    }
    
    private static void unidirectional(EntityManager em) {
        
        // one to many 단방향
        // fk 가 member table에 있으므로 insert 후 추가적인 update를 한다
        Member member1 = new Member("yusik");
        Member member2 = new Member("jason");
    
        Team team = new Team("Korea");
        
        team.getMembers().add(member1);
        team.getMembers().add(member2);
        
        em.persist(member1);
        em.persist(member2);
        em.persist(team);

    }
}

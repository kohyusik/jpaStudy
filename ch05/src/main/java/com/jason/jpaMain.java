package com.jason;

import com.jason.entity.Member;
import com.jason.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("jpa-ch05");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            execute(em);
            tx.commit();


        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }

    private static void execute(EntityManager em) {

        Team team = new Team();
        team.setName("Korea");
        em.persist(team);

        Member member1 = new Member();
        member1.setName("koh");
        member1.setTeam(team);
        em.persist(member1);

        Member member2 = new Member();
        member2.setName("yusik");
        member2.setTeam(team);
        em.persist(member2);
    }
}

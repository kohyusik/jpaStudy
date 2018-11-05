package jason;

import jason.entity.Member;
import jason.entity.Team;

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

            tx.begin();
            unidirectional(em);
            tx.commit();
    
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }
    
    private static void unidirectional(EntityManager em) {
        
        // Release v 1.0.0
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

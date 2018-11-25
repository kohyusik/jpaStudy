package jason;

import jason.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("jpa-ch09");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            type(em);
            tx.commit();
    
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }
    
    private static void type(EntityManager em) {

        Member member1 = new Member("koh");
        Member member2 = new Member("jason");

        em.persist(member1);
        em.persist(member2);

    }
}

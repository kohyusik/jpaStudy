package jason;

import jason.entity.Member;
import jason.entity.Seller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("jpa-ch07-2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            mappedSuperClass(em);
            tx.commit();
    
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }
    
    private static void mappedSuperClass(EntityManager em) {

        Member member = new Member();
        member.setEmail("kohyu@maver.com");
        member.setName("kohyui");

        Seller seller = new Seller();
        seller.setShopName("Lobs");
        seller.setName("Lobs man");

        em.persist(member);
        em.persist(seller);

    }
}

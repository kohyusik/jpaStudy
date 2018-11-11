import com.jason.entity.Child;
import com.jason.entity.Parent;
import com.jason.entity.ParentId;
import com.jason.entity.embedded.Mother;
import com.jason.entity.embedded.MotherId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("jpa-ch07-3-2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            insert(em);
            tx.commit();

            tx.begin();
            select(em);
            tx.commit();
    
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }

    private static void insert(EntityManager em) {

        Parent parent = new Parent();

        parent.setId1("my_id1");
        parent.setId2("my_id2");
        parent.setName("yusik");
        em.persist(parent);

        Child child = new Child();
        child.setId("my_child_id1");
        child.setParent(parent);

        em.persist(child);


        Mother mother = new Mother();
        MotherId motherId = new MotherId("mt_id1", "mt_id2");
        mother.setMotherId(motherId);
        mother.setName("엄마");

        em.persist(mother);


    }

    private static void select(EntityManager em) {

        ParentId parentId = new ParentId("my_id1", "my_id2");
        Parent foundParent = em.find(Parent.class, parentId);
        System.out.println(foundParent);
    }
}

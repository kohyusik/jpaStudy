package jason;

import jason.entity.Member;
import jason.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class jpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("jpa-ch08");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            referentce(em);
            tx.commit();
    
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }
    
    private static void referentce(EntityManager em) throws InvocationTargetException, IllegalAccessException {

//        Member member1 = new Member("koh");
//        Member member2 = new Member("jason");
//
//        Team team = new Team("Korea");
//
//        team.getMembers().add(member1);
//        team.getMembers().add(member2);
//
//        em.persist(member1);
//        em.persist(member2);
//        em.persist(team);
//
//        Locker locker = new Locker("lock-15");
//        System.out.println(">>>> persist");
//        em.persist(locker);
//        member2.setLocker(locker);
        
        
        Team foundTeam = em.getReference(Team.class, 1l);
        System.out.println(">>>>>> Proxy class : ");
        System.out.println(foundTeam.getClass());

        Class clazz = foundTeam.getClass();

        Field[] fields = clazz.getFields();

        System.out.println(">>> super class");
        System.out.println(clazz.getSuperclass());

        System.out.println(">>> field list");
        for (Field field : fields) {
            System.out.println(field.getType());
        }

        System.out.println(">>> method list");
        Method[] methods = clazz.getMethods();
        for(Method method : methods) {
            System.out.println(method.getName());

            if (method.getName().equals("getId")) {
                Object returnVal = method.invoke(foundTeam);
                System.out.println(">>>>>>>Invoke getId");
                System.out.println(returnVal);
            }

//            if (method.getName().equals("getName")) {
//                Object returnVal = method.invoke(foundTeam);
//                System.out.println(">>>>>>>Invoke getName");
//                System.out.println(returnVal);
//            }
        }


        System.out.println(">>>>>> team.getMember : ");
        System.out.println(foundTeam.getMembers().getClass());


        System.out.println(">>>>>> member jpql : ");
        String jpql = "select a from Member as a where a.name = 'koh'";
        List<Member> memberList = em.createQuery(jpql, Member.class).getResultList();
        System.out.println(memberList.get(0).getName());

//        System.out.println(">>>>>> member.getLock : ");
//        System.out.println(foundTeam.getMembers().get(1).getLocker().getName());

    }
}

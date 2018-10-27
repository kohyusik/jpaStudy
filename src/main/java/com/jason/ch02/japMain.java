package com.jason.ch02;

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
            logic(em);  //비즈니스 로직
            tx.commit();


        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();




    }

    private static void logic(EntityManager em) {

        Member[] memberArr = new Member[100];

        for (int i = 0; i < 100; i++) {

            String id = "id-" + i;
            Member member = new Member();
            member.setId(id);
            member.setName("koh");
            member.setAge(26);
            em.persist(member);

            memberArr[i] = member;

        }

        Member findMemberBefore = em.find(Member.class, "id0");
        System.out.println("findMember= " + findMemberBefore);

        //수정
        memberArr[0].setAge(20);

        //한 건 조회
        Member findMember = em.find(Member.class, "id0");
        System.out.println("findMember= " + findMember);

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList().subList(0, 2);
        System.out.println("members.size=" + members);

        // JPQL
        em.createQuery("DELETE FROM Member e").executeUpdate();
        // SQL
//        em.createNativeQuery("TRUNCATE TABLE MEMBER").executeUpdate();


    }

}

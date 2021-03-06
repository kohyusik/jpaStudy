package jason;

import jason.entity.Locker;
import jason.entity.Member;
import jason.entity.Team;
import jason.entity.join.Album;
import jason.entity.join.Book;
import jason.entity.join.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("jpa-ch07");
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

        Member member1 = new Member("koh");
        Member member2 = new Member("jason");

        Team team = new Team("Korea");

        team.getMembers().add(member1);
        team.getMembers().add(member2);

        em.persist(member1);
        em.persist(member2);
        em.persist(team);

        Locker locker = new Locker("lock-15");
        System.out.println(">>>> persist");
        em.persist(locker);
        member2.setLocker(locker);
        
        
        Team foundTeam = em.find(Team.class, 1l);
        System.out.println(">>>>>> team.getName : ");
        System.out.println(foundTeam.getName());

        System.out.println(">>>>>> team.getMember : ");
        System.out.println(foundTeam.getMembers().get(1).getName());

        System.out.println(">>>>>> member.getLock : ");
        System.out.println(foundTeam.getMembers().get(1).getLocker().getName());


        Movie movie = new Movie();
        movie.setActor("원빈");
        movie.setDirector("jason");
        movie.setName("yusik");
        movie.setPrice(20000);

        Album album = new Album();
        album.setArtist("J..");
        album.setName("GANGNAM style");
        album.setPrice(15000);

        Book book = new Book();
        book.setIsbn("awht89a23tioa36098a265ua236hy");
        book.setAuthor("giyom");
        book.setName("spring");
        book.setPrice(8700);

        em.persist(movie);
        em.persist(album);
        em.persist(book);

    }
}

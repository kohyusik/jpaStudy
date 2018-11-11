package jason;

import jason.entity.table.Album;
import jason.entity.table.Book;
import jason.entity.table.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("jpa-ch07-1-3");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

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

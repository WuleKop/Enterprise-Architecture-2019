package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AppBook {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Book and set values in it
        Book book1 = new Book("Head First Design Patterns", "9780596007126", "Eric Freeman",55.99,
                new GregorianCalendar(2006, Calendar.OCTOBER, 29 ).getTime());
        // save the Book
        em.persist(book1);
        // Create new instance of Book and set values in it
        Book book2 = new Book("Refactoring: Improving the Design of Existing Code", "9780134757599",
                " Martin Fowler",59.99, new GregorianCalendar(2019, Calendar.OCTOBER, 23 ).getTime());
        // save the Book
        em.persist(book2);
        // Create new instance of Book and set values in it
        Book book3 = new Book("C# in Depth", "9781617294532", " Jon Skeet",49.99,
                new GregorianCalendar(2018, Calendar.MARCH, 14 ).getTime());
        // save the Book
        em.persist(book3);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all books
        TypedQuery<Book> query = em.createQuery("from Book ", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("Title: " + book.getTitle() + "\n ISBN: "+book.getISBN()+"\n Author: " +
                    book.getAuthor()+ "\n Price: "+book.getPrice()+"\n Published Date: "+book.getPublish_date());
        }
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // Retrive Books
        TypedQuery<Book> query2 = em.createQuery("from Book ", Book.class);
        List<Book> bookList2 = query2.getResultList();
        // Update the title and price of the second Book
        bookList2.get(1).setTitle("Patterns of Enterprise Application Architecture");
        bookList2.get(1).setPrice(56.00);
        // Remove Book 1
        em.remove( bookList2.get(0));
        em.getTransaction().commit();
        em.close();
    }
}

package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students ", edu.mum.cs544.Students.class);
        List<Students> studentsList = query.getResultList();
        System.out.println("Names: ");
        for (Students s : studentsList) {
            System.out.println(s.getName());
        }
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        Students students=new Students(987088,"Wuletaw","wule2000@gmail.com","12345");
        em.persist(students);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> query2 = em.createQuery("from edu.mum.cs544.Students ", edu.mum.cs544.Students.class);
        List<Students> studentsList2 = query2.getResultList();
        System.out.println("Names: ");
        for (Students s : studentsList2) {
            System.out.println(s.getName());
        }
        em.getTransaction().commit();
        em.close();

    }
}

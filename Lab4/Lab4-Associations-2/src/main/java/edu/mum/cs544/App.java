package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;

public class App {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee1=new Employee("Chris Bailey",56);
        Employee employee2=new Employee("Hank Moody",48);

        Department department1=new Department("Computer Science","Mclaughin Building");

        department1.addEmployee(employee1);
        department1.addEmployee(employee2);
        em.persist(department1);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Publisher publisher1=new Publisher("Wiley and Sons","Hoboken, New Jersy ");

        Book book1=new Book("Introduction to Alagorithm","Jean Rodrigez");
        Book book2=new Book("The Alchemist","Paulo Coelho");
        book1.setPublisher(publisher1);
        book2.setPublisher(publisher1);
        em.persist(book1);
        em.persist(book2);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Student student1=new Student(987083L,"Wuletaw Tefera");
        Student student2=new Student(987056L,"Nicole Zena");

        Course course1=new Course("Web Application Architecture","Computer Science");
        Course course2=new Course("Algorithms","Computer Science");
        student1.addCourse(course1);
        student2.addCourse(course2);
        em.persist(student1);
        em.persist(student2);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Reservation reservation1=new Reservation("Hilton Hotel","Table", LocalDate.of(2019,9,16),24);
        Reservation reservation2=new Reservation("United Airlines","Seat",LocalDate.of(2019,10,29),46);
        Customer customer=new Customer("Abeba Ibrahim","Columbus,Ohio");
        reservation1.addBook(book1);
        reservation2.addBook(book1);
        customer.addReservation(reservation1);
        customer.addReservation(reservation2);
        em.persist(customer);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Office office=new Office("Maharishi University of Management","Fairfield, Iowa");
        office.addEmployee(employee1);
        office.addEmployee(employee2);
        office.removeEmployee(employee2);
        em.persist(office);
        em.getTransaction().commit();






    }
}


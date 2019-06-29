package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Laptop laptop1=new Laptop("Lenovo","123456");
        Laptop laptop2=new Laptop("hp","56789");

        Employee employee=new Employee("Wuletaw Tefera","Fairfield,Iowa");
        employee.addLaptop(laptop1);
        employee.addLaptop(laptop2);
        em.persist(employee);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Passenger passenger1=new Passenger("Wuletaw Tefera","Fairfield, Iowa");
        Passenger passenger2=new Passenger("Bereket Babiso","Detroit, Illinois");

        Flight flight =new Flight("United Airlines","789","Cedar Rapids","Michigan");
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        em.persist(flight);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Student student1=new Student(987083L,"Nicole Zena","Kigali, Rwanda");
        Student student2=new Student(987067L,"Abenezer Mekonnen","Addis Ababa, Ethiopia");

        School school=new School("Maharishi University of Management","Fairfield, Iowa");
        school.addStudent(student1);
        school.addStudent(student2);
        em.persist(school);
        em.getTransaction().commit();



    }
}


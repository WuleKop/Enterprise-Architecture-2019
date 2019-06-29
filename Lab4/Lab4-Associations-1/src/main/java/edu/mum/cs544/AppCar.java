package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppCar {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Owner owner1=new Owner("Wuletaw Tefera", "Fairfield, Iowa");
        Owner owner2=new Owner("David Jones", "Chicago, Illinois");


        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        // save the car
        car1.setOwner(owner1);
        em.persist(car1);
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        // save the car
        car2.setOwner(owner2);
        em.persist(car2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("Brand: " + car.getBrand() + " , Owner: "
                    +car.getOwner().getName()+" , Address: "+car.getOwner().getAddress());
        }
        em.getTransaction().commit();
        em.close();
    }
}


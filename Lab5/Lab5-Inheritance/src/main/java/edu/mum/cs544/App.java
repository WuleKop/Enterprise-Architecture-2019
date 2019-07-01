package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String [] args) {

        emf= Persistence.createEntityManagerFactory("cs544");
        EntityManager em=emf.createEntityManager();

        em.getTransaction().begin();

        Customer customer=new Customer("Daivd","Ayewo");
        Order order1=new Order(LocalDate.now());
        Order order2=new Order(LocalDate.of(2019,8,26));
        OrderLine orderLine1=new OrderLine(10);
        OrderLine orderLine2=new OrderLine(20);
        Product product=new Product("Macbook Pro", "Laptop");
        Product cd=new CD("Thriller","The Best Song of MJ","Micheal Jackson");
        Product dvd=new DVD("Mission Impossible","Triology of MI Movies","Action");
        Product book=new Book("A Song of Ice and Fire","The Book that Game of Thrones is based on","George R.R Martin");
        em.persist(product);
        em.persist(cd);
        em.persist(dvd);
        em.persist(book);
        customer.addOrder(order1);
        customer.addOrder(order2);
        em.persist(customer);
        order1.addOrderLine(orderLine1);
        order2.addOrderLine(orderLine2);
        em.persist(order1);
        em.persist(order2);
        orderLine1.setProduct(book);
        orderLine2.setProduct(dvd);
        em.persist(orderLine1);
        em.persist(orderLine2);

        em.getTransaction().commit();

        //Let's Check The Data Base for Customer and Order then we can continue like this ...

        System.out.println("           ****** Database Outputs ******");
        Customer c=em.find(Customer.class,customer.getId());
        System.out.println("Customer: "+c.getFirstName()+" "+c.getLastName());
        List<Order> cOrder=c.getOrderList();
        System.out.print("Orders:");
        for(Order o:cOrder) {
            System.out.print(", ID "+o.getOrderId()+" Date "+o.getDate());
        }
        System.out.println();
        System.out.println("Customers Ordered Products: ");
        System.out.println(c.getOrderList().get(0).getOrderLineList().get(0).getProduct());
        System.out.println(c.getOrderList().get(1).getOrderLineList().get(0).getProduct());

        em.close();

    }
}

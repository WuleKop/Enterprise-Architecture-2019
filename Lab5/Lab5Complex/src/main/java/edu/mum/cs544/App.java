package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String [] args) {
        emf= Persistence.createEntityManagerFactory("cs544");
        EntityManager em= emf.createEntityManager();

        em.getTransaction().begin();

        Doctor doctor=new Doctor("Eye Doctor","Frank","Brown");
        Payment payment=new Payment("12/06/08",100);
        Patient patient=new Patient("John Doe","100 Main Street","23114","Boston");
        Appointment appointment=new Appointment("15/05/08");
        appointment.setPatient(patient);
        appointment.setPayment(payment);
        appointment.setDoctor(doctor);
        em.persist(appointment);
        em.getTransaction().commit();

        System.out.println("         ******Printing the Database******");
        Appointment appointment1=em.find(Appointment.class,appointment.getId());
        System.out.println("Patient Name: "+appointment1.getPatient().getName()+", Street: "+appointment1.getPatient().getStreet() +
                ", City: "+appointment1.getPatient().getCity()+", ZIP: "+appointment1.getPatient().getZip());
        System.out.println("Appointement Date: "+appointment1.getAppdate()+", Pay Date: "+appointment1.getPayment().getPaydate()
        +", Amount: "+appointment1.getPayment().getAmount());
        System.out.println("Doctor Name: "+appointment1.getDoctor().getFirstname()+" "+appointment1.getDoctor().getLastname()+", Type: "+appointment1.getDoctor().getDoctortype());


        em.close();
    }
}

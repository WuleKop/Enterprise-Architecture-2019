package edu.mum.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {

  public static void main(String[] args) {
      ApplicationContext ctx = new ClassPathXmlApplicationContext(
              "context/applicationContext.xml");
      UserService userService=(UserService)ctx.getBean("userServiceImpl");
      User user=new User();
      user.setFirstName("John"); user.setLastName("Doe");
      user.setEmail("jDoe@gmail.com"); user.setAdmin(true);
      user.setVersion(20180923); user.setRating(5);
      userService.save(user);
      User u=userService.findByEmail("jDoe@gmail.com");
      System.out.println("     ********User********");
      System.out.println("User Name: "+u.getFirstName()+" "+u.getLastName());

      u.setFirstName("Wuletaw");
      User u1=userService.update(u);
      System.out.println("     ********User********");
      System.out.println("User Name: "+u1.getFirstName()+" "+u1.getLastName());


      //Changing to unmanaged Version (Will Produce Error)
      userService.clear();



     
  }  
  
 }
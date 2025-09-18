package com.kodenst.hibernate_emp_system;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
	 private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            
	
             static void getdata() {
        	 Scanner sc = new Scanner(System.in);

		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 System.out.println("enter id");
		 int id = sc.nextInt();
		 Employee emp = session.get(Employee.class,id);
		 if (emp != null) {
			 System.out.println(emp);
		 } else {
			 System.out.println("data not exixts");
		 }
		 transaction.commit();
		 session.close();
		// sessionFactory.close();
		// sc.close();
		 }
	  
	    static void save() {
		Scanner sc = new Scanner(System.in);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("enter name, email,age,sex");
		String name = sc.next();
		String email = sc.next();
		sc.nextLine();
		int age = sc.nextInt();
		sc.nextLine();
		String sex = sc.next();
		
		Employee emp = new Employee(name,email,age,sex);
		session.persist(emp);
		transaction.commit();
		session.close();
		//sessionFactory.close();
		//sc.close();
		}
	    static void update() {
		Scanner sc = new Scanner(System.in);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("enter object id to see and update the details");
		int id = sc.nextInt();
		Employee emp = session.get(Employee.class, id);
		if (emp != null) {
			System.out.println("press 1 to update name");
			System.out.println("press 2 to update email");
			System.out.println("press 3 to update age");
			
			int object = sc.nextInt();
			switch(object) {
			
			case 1 :  
				String name = sc.next();
				emp.setName(name);
				session.persist(emp);
				transaction.commit();
				session.close();
				//sessionFactory.close();
				//sc.close();
			    break;
			    
			case 2 : 
				String email = sc.nextLine();
				emp.setEmail(email);
				session.persist(emp);
				transaction.commit();
				session.close();
				//sessionFactory.close();
				//sc.close();
				break;
				
			case 3 :
				int age = sc.nextInt();
				emp.setAge(age);
				session.persist(emp);
				transaction.commit();
				session.close();
			   //sessionFactory.close();
			   //sc.close();
				default :
					
					System.out.println("sorry you are selected out of option");
					}
           }
		
		
		
	}
	static void delete() {
		
		Scanner sc = new Scanner(System.in);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("enter id to delete");
		int id = sc.nextInt();
		
		Employee emp = session.get(Employee.class,id);
		if (emp != null) {
			System.out.println(emp);
			session.remove(emp);
			transaction.commit();
			session.close();
			//sessionFactory.close();
			//sc.close();
		} else {
			System.out.println("id is not valid");
		}
	}
	
	
	
	 public static void main( String[] args )
    {
		 Scanner sc = new Scanner(System.in);
    System.out.println("welcome to emp management system");
 	while (true) {
				 System.out.println("our menu is "
		 		+ "  , press 1 to see the data"
		 		+ "  , press 2 to save the data"
		 		+ " , press 3 to update the date"
		 		+ ", press 4 to delete the data"
		 		  + ", press 0 to stop");
		 if (!sc.hasNextInt()) {
			 System.out.println("not a number");
			 sc.nextLine();
			 continue;
		 }
    	// Scanner sc = new Scanner(System.in);
		 int num  = sc.nextInt();
		 switch (num) {
		 
		 case 1 :
			 App.getdata();
			 break;
			
		 case 2 :
			     App.save();
			     break;
		 case 3 :
			     App.update();
			     break;
		  case 4:
			     App.delete();
			     break;
		 case 0 :
			 System.out.println("good bye");
			 sc.close();
	         sessionFactory.close();
			 return;
			 default :
				 System.out.println("you entred a wrong number");
				 break;
		
		 }
    	}
		}
    	}


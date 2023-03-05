package com.edubridge.project;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
	private static Swiggy res = new Swiggy();
	private static Scanner scan = new Scanner(System.in);
	public static void toCreateConnection() {
		try {
    		Configuration config = new Configuration().configure().addAnnotatedClass(Swiggy.class);
    		SessionFactory sessionFact = config.buildSessionFactory(); 
    		Session session = sessionFact.openSession();
    		toManipulateData(sessionFact,session);
    	
    		}catch(HibernateException obj) {

    		}
    		catch(Exception obj) {

    		}
		
	}
	
	public static void toManipulateData(SessionFactory sessionfact,Session session) {
	System.out.println("Please choose the option 1.Add the Restaurant , 2. Display the Restaurant, 3. Update the Restaurant, 4. Search the Restaurant, 5.Delete the restaurant, 6.Log out");
	int userChoice;
	do {
	userChoice=scan.nextInt();	
	switch(userChoice) {
	case 1:
		  addRestaurant(session);
	      break;
	case 2:
	      display(res);
	      break;
	case 3:
	      updateById(session);
	      break;
	case 4:search(session);
	       break;
	case 5:deleteById(session);
	       break;
	case 6:Swiggy.toCallLogOut();
	       sessionfact.close();
	       break;
	case 7:sessionfact.close();
	       break;
	}
	}while(userChoice!=7);
}
      	
    private static void addRestaurant(Session session) {
    		System.out.println("Enter the restaurant detail to add");
    		session.beginTransaction();
    		Integer id = (Integer) session.save(getRestaurantList());
    		System.out.println("Employee is created with id :"+id);
    		session.getTransaction().commit();

    	}

    private static void deleteById(Session session) {
    		
    		System.out.println("Enter the position of the id to delete");
    		int id = scan.nextInt();
    		Swiggy res = session.get(Swiggy.class, id);

    		if(res != null) {
    			session.beginTransaction();
    			session.remove(res);
    			System.out.println("Deleted Successfully");
    			session.getTransaction().commit();
    		}
    		else {
    			System.out.println("Restaurant id doesnt exists..");

    		}	
    	}
    private static void updateById(Session session) {
    		System.out.println("Enter the position of id to update");
    		int id = scan.nextInt();
    		Swiggy res = session.get(Swiggy.class, id);
    		if(res != null) {
    			//scanner obj 
    			System.out.println("Enter the restaurant name");
    			res.setRes_Name(scan.next());
        		System.out.println("Enter the owner name");
        		res.setOwn_Name(scan.next());
        		System.out.println("Enter the food type");
        		res.setFood_Type(scan.next());
        		System.out.println("Enter the location");
        		res.setLocation(scan.next());
        		System.out.println("Enter the price");
        		res.setPrice(scan.nextInt());
        		System.out.println("Enter the rating");
        		res.setRatings(scan.nextDouble());
    			session.beginTransaction();
    			session.persist(res);
    			session.getTransaction().commit();
    		}
    		else {
    			System.out.println("Restaurant id doesnt exists..");

    		}	
    	}
    private static void search(Session session){
    		System.out.println("Enter the position of the id to search");
    		int id = scan.nextInt();
    		Swiggy res = session.get(Swiggy.class, id);
    		if(res != null) {
    			System.out.println(res);
    		}
    		else {
    			System.out.println("Restaurant id doesnt exists..");

    		}
    	}
    private static void display(Swiggy res){
        		System.out.println(res);
    	}
    private static Swiggy getRestaurantList() {
    	    res.getId();
    		System.out.println("Enter the restaurant name");
    		res.setRes_Name(scan.next());
    		System.out.println("Enter the owner name");
    		res.setOwn_Name(scan.next());
    		System.out.println("Enter the food type");
    		res.setFood_Type(scan.next());
    		System.out.println("Enter the location");
    		res.setLocation(scan.next());
    		System.out.println("Enter the price");
    		res.setPrice(scan.nextInt());
    		System.out.println("Enter the rating");
    		res.setRatings(scan.nextDouble());
    		return res;
    	}
    	
    public static void main( String[] args )
        {
        	System.out.println("Enter the user name");
        	String username = scan.next();
        	System.out.println("Enter the password");
        	String password = scan.next();
        	Swiggy.toCheckLogin(username, password);
        	
        }

		
    

	}

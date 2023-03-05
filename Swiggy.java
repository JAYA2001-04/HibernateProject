package com.edubridge.project;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "restaturant")

public class Swiggy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //start by 1 and inc by 1
	private Integer id;

	public Integer getId() {
		return id;
	}
	
	private String res_Name;
	private String own_Name;
	private String food_Type;
	private Integer price;
	private String location;
	private Double ratings;
	
	private static String USERNAME= "Jayashree";
	private static String PASSWORD ="jaya@0123";

	
	public String getRes_Name() {
		return res_Name;
	}
	public void setRes_Name(String res_Name) {
		this.res_Name = res_Name;
	}
	public String getOwn_Name() {
		return own_Name;
	}
	public void setOwn_Name(String own_Name) {
		this.own_Name = own_Name;
	}
	public String getFood_Type() {
		return food_Type;
	}
	public void setFood_Type(String food_Type) {
		this.food_Type = food_Type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getRatings() {
		return ratings;
	}
	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}
	public static void toCheckLogin(String user_Name,String pass_Word) {
		if(user_Name.equals(USERNAME)&&pass_Word.equals(PASSWORD)) {
			App.toCreateConnection();	
		}
		else {
		 System.out.println("Username/password is incorrect");
		}
		
	}
	public static void toCallLogOut() {
		System.out.println("Logged out successfully");
		
	}
	@Override
	public String toString() {
		return "Restaurant list [res_Id=" + id + ", res_Name=" + res_Name + ", own_Name=" + own_Name + ", food_Type="
				+ food_Type + ", price=" + price + ", location=" + location + ", ratings=" + ratings + "]";
	}


}

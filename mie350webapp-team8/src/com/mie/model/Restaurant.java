package com.mie.model;

import java.util.ArrayList;

public class Restaurant {
	
    private String address;
    private String cuisine;
    private String hoursOperation; // Date or string representing hours of operation?
    private int id;
    private String name;
    private ArrayList<String> photos;
    private String price; 
	private double rating;
    private ReviewsList reviewsList; // Need to create class for ReviewsList objects
     
    // Getters
    public String getAddress(){
        return this.address;
    }

    public String getCuisine(){
        return this.cuisine;
    }

    public String getHours(){
        return this.hoursOperation;
    }

	public int getId(){
		return this.id;
	}

    public String getName(){
        return this.name;
    }

    public String getPrice(){
        return this.price;
    }
    
    public ArrayList<String> getPhotos(){
    	return this.photos;
    }

    public double getRating(){
        return this.rating;
    }

    public ReviewsList getReviewsList(){
        return this.reviewsList;
    }

    // Setters
    public void setId(int id){
		this.id = id;
	}

    public void setRating(double rating){
        this.rating = rating;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }
    
    public void setPhotos(ArrayList<String> photos){
    	this.photos = photos;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setCuisine(String cuisine){
        this.cuisine = cuisine;
    }

    public void setReviewsList(ReviewsList reviewsList){
        this.reviewsList = reviewsList;
    }

    public void setHours(String hoursOperation){
        this.hoursOperation = hoursOperation;
    }

    // Methods
	public void readData(String address, String cuisine, String hoursOperation, int id, String name, ArrayList<String> photos, String price, double rating, ReviewsList reviewsList) {
			this.address = name;
			this.cuisine = cuisine;
            this.hoursOperation = hoursOperation;
            this.id = id;
            this.name = name;
            this.photos = photos;
            this.price = price;
            this.rating = rating;
            this.reviewsList = reviewsList;
	}
}

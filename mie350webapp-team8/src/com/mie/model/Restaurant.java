package com.mie.model;

import java.util.Iterator;

public class Restaurant {
	
    private String address;
    private String cuisine;
    private String hoursOperation;
    private int id;
    private String name;
    private String picture;
    private String price; 
	private double rating;
    private ReviewsList reviewsList = new ReviewsList();
    private String website;
     
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
    
    public String getPicture(){
    	return this.picture;
    }

    public double getRating(){
        return this.rating;
    }

    public ReviewsList getReviewsList(){
        return this.reviewsList;
    }
    
    public String getWebsite(){
    	return this.website;
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
    
    public void setPicture(String picture){
    	this.picture = picture;
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
    
    public void setWebsite(String website){
    	this.website = website;
    }

    // Methods
	public void readData(String address, String cuisine, String hoursOperation, int id, String name, String picture, String price, double rating, ReviewsList reviewsList, String website) {
			this.address = name;
			this.cuisine = cuisine;
            this.hoursOperation = hoursOperation;
            this.id = id;
            this.name = name;
            this.picture = picture;
            this.price = price;
            this.rating = rating;
            this.reviewsList = reviewsList;
            this.website = website;
	}
	
	public void printContents(){
		System.out.println("Address: "+this.address+"\nCuisine: "+this.cuisine
				+"\nHours of Operation: "+this.hoursOperation+"\nRestaurant ID: "+this.id+
				"\nRestaurant Name: "+this.name+"\nPrice: "+this.price+"\nRating: "+this.rating+"\nWebsite: "+this.website);
		Iterator iterator = reviewsList.iterator(); 
		while (iterator.hasNext()){
			Review review = (Review) iterator.next();
			review.printContents();
		}
	}
	
	//add new reply to review
	public void addReview(Review review) {
		reviewsList.add(review);
	}
}

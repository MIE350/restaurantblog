package com.mie.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.*;

import com.mie.model.Restaurant;
import com.mie.model.Review;
import com.mie.model.Student;
import com.mie.util.DbUtil;
import com.mie.model.RestaurantList;
import com.mie.model.ReviewList;

import java.sql.Array;

public class RestaurantDao {
	
	private Connection connection;
	
	public void main(){
		
		RestaurantList restaurants = (RestaurantList) getAllRestaurants();
		Iterator iterator = restaurants.iterator();
		while (iterator.hasNext()){
			Restaurant restaurant = (Restaurant) iterator.next();
			addReviews(restaurant);
			restaurant.printContents();
		}
		
	}

	public RestaurantDao() {
		connection = DbUtil.getConnection();
	}

	public void addRestaurant(Restaurant restaurant) {
		
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into restaurants(address,cuisine,hours,id,name,picture,price,rating, website) values (?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, restaurant.getAddress());
			ps.setString(2, restaurant.getCuisine());
			ps.setString(3, restaurant.getHours());
			ps.setInt(4, restaurant.getId());
			ps.setString(5, restaurant.getName());
			ps.setString(6, restaurant.getPicture());
			ps.setString(7, restaurant.getPrice());
			ps.setDouble(8, restaurant.getRating());
			ps.setString(9, restaurant.getWebsite());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public RestaurantList getAllRestaurants() {

		RestaurantList restaurants = new RestaurantList();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from restaurants");
			while (rs.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setAddress(rs.getString("address"));
				restaurant.setCuisine(rs.getString("cuisine"));
				restaurant.setHours(rs.getString("hours"));
				restaurant.setId(rs.getInt("id"));
				restaurant.setName(rs.getString("name"));
				restaurant.setPicture(rs.getString("picture"));
				restaurant.setPrice(rs.getString("price"));
				restaurant.setRating(rs.getDouble("rating"));
				restaurant.setWebsite(rs.getString("website"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurants;
	}
	
	public void addReviews(Restaurant restaurant){
		
		int restaurantId = restaurant.getId();
		
		try {
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from reviews where restaurantID ="+restaurantId);
			while (rs.next()){
				Review review = new Review();
				review.setReviewContent(rs.getString("review"));
				review.setRating(rs.getInt("reviewID"));
				review.setUserId(rs.getInt("studentID"));
				review.setRestaurantId(rs.getInt("restaurantID"));
				review.setReviewId(rs.getInt("reviewID"));
				review.setPostTime(rs.getTimestamp("postTime"));
				restaurant.addReview(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addAllReviews(){
		
		RestaurantList restaurants = getAllRestaurants();
		
		Iterator iterator = restaurants.iterator();
		
		while (iterator.hasNext()){
			Restaurant restaurant = (Restaurant) iterator.next();
			addReviews(restaurant);
		}
	}
	
	public ArrayList<Restaurant> sortByPriceAscending(ArrayList<Restaurant> filteredRestaurants){
		
		RestaurantList restaurants = new RestaurantList();
		
		if (filteredRestaurants.isEmpty()){
			restaurants = getAllRestaurants();
		}
		else{
			for (Restaurant restaurant : filteredRestaurants){
				restaurants.add(restaurant);
			}
		}
		ArrayList<Restaurant> restaurantsByPrice = new ArrayList<Restaurant>();
		
		Iterator iterator = restaurants.iterator();
		
		while (iterator.hasNext()){
			Restaurant restaurant = (Restaurant) iterator.next();
			restaurantsByPrice.add(restaurant);
		}
		
		Collections.sort(restaurantsByPrice, new Comparator<Restaurant>() {
			
			@Override
			public int compare(Restaurant o1, Restaurant o2) {
				return o1.getPrice().compareTo(o2.getPrice());
			}
		});
		
		return restaurantsByPrice;
	}
	
	public ArrayList<Restaurant> sortByPriceDescending(ArrayList<Restaurant> filteredRestaurants){
		
		RestaurantList restaurants = new RestaurantList();
		
		if (filteredRestaurants.isEmpty()){
			restaurants = getAllRestaurants();
		}
		else{
			for (Restaurant restaurant : filteredRestaurants){
				restaurants.add(restaurant);
			}
		}
		
		ArrayList<Restaurant> restaurantsByPrice = new ArrayList<Restaurant>();
		
		Iterator iterator = restaurants.iterator();
		
		while (iterator.hasNext()){
			Restaurant restaurant = (Restaurant) iterator.next();
			restaurantsByPrice.add(restaurant);
		}
		
		Collections.sort(restaurantsByPrice, new Comparator<Restaurant>() {
			
			@Override
			public int compare(Restaurant o1, Restaurant o2) {
				return o2.getPrice().compareTo(o1.getPrice());
			}
		});
		
		return restaurantsByPrice;
	}
	
	public ArrayList<Restaurant> sortByRatingAscending(ArrayList<Restaurant> filteredRestaurants){
		
		RestaurantList restaurants = new RestaurantList();
		
		if (filteredRestaurants.isEmpty()){
			restaurants = getAllRestaurants();
		}
		else{
			for (Restaurant restaurant : filteredRestaurants){
				restaurants.add(restaurant);
			}
		}
		
		ArrayList<Restaurant> restaurantsByRating = new ArrayList<Restaurant>();
		
		Iterator iterator = restaurants.iterator();
		
		while (iterator.hasNext()){
			Restaurant restaurant = (Restaurant) iterator.next();
			restaurantsByRating.add(restaurant);
		}
		
		Collections.sort(restaurantsByRating, new Comparator<Restaurant>() {
			
			@Override
			public int compare(Restaurant o1, Restaurant o2) {
				return Double.compare(o1.getRating(), o2.getRating());
			}
		});
		
		return restaurantsByRating;
		
	}
	
	public ArrayList<Restaurant> sortByRatingDescending(ArrayList<Restaurant> filteredRestaurants){
		
		RestaurantList restaurants = new RestaurantList();
		
		if (filteredRestaurants.isEmpty()){
			restaurants = getAllRestaurants();
		}
		else{
			for (Restaurant restaurant : filteredRestaurants){
				restaurants.add(restaurant);
			}
		}
		
		ArrayList<Restaurant> restaurantsByRating = new ArrayList<Restaurant>();
		
		Iterator iterator = restaurants.iterator();
		
		while (iterator.hasNext()){
			Restaurant restaurant = (Restaurant) iterator.next();
			restaurantsByRating.add(restaurant);
		}
		
		Collections.sort(restaurantsByRating, new Comparator<Restaurant>() {
			
			@Override
			public int compare(Restaurant o1, Restaurant o2) {
				return Double.compare(o2.getRating(), o1.getRating());
			}
		});
		
		return restaurantsByRating;
		
	}
	
	public ArrayList<Restaurant> filterByCuisine(String filterCuisine){
		
		RestaurantList restaurants = getAllRestaurants();
		ArrayList<Restaurant> restaurantsByCuisine = new ArrayList<Restaurant>();
		
		Iterator iterator = restaurants.iterator();
		
		while (iterator.hasNext()){
			Restaurant restaurant = (Restaurant) iterator.next();
			
			if (restaurant.getCuisine() == filterCuisine) {
				restaurantsByCuisine.add(restaurant);
			}
		}
		
		return restaurantsByCuisine;
	}
	
	public ArrayList<Restaurant> filterByKeyword(String filterKeyword){
		
		RestaurantList restaurants = getAllRestaurants();
		ArrayList<Restaurant> restaurantsByKeyword = new ArrayList<Restaurant>();
		
		Iterator iterator = restaurants.iterator();
		
		while (iterator.hasNext()){
			Restaurant restaurant = (Restaurant) iterator.next();
			
			if (restaurant.getName().contains(filterKeyword)) {
				restaurantsByKeyword.add(restaurant);
			}
		}
		return restaurantsByKeyword;
	}
	
	public void computeRating(Restaurant restaurant){
		
		int restaurantId = restaurant.getId();
		
		try {
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select avg(rating) from reviews where restaurantID ="+restaurantId);
			restaurant.setRating(rs.getDouble("avg(rating"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
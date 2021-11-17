package com.mie.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.mie.model.Restaurant;
import com.mie.model.Student;
import com.mie.util.DbUtil;
import com.mie.model.RestaurantList;
import com.mie.model.ReviewsList;
import java.sql.Array;

public class RestaurantDao {
	
	private Connection connection;

	public RestaurantDao() {
		connection = DbUtil.getConnection();
	}

	public void addRestaurant(Restaurant restaurant) {
		
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into restaurants(address,cuisine,hours,restaurantID,name,photos,price,rating,reviewsList) values (?,?,?,?,?,?,?,?,?)");
			
			//Array photosArray = connection.createArrayOf("VARCHAR", restaurant.getPhotos().toArray());
			
			ps.setString(1, restaurant.getAddress());
			ps.setString(2, restaurant.getCuisine());
			ps.setString(3, restaurant.getHours());
			ps.setInt(4, restaurant.getId());
			ps.setString(5, restaurant.getName());
			// ps.setArray(6, photosArray);
			ps.setString(7, restaurant.getPrice());
			ps.setDouble(8, restaurant.getRating());
			// ps.setInt(9, restaurant.getReviewsList());
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
				restaurant.setId(rs.getInt("restaurantID"));
				restaurant.setName(rs.getString("name"));
				// restaurant.setPhotos(rs.getArray("photos"));
				restaurant.setPrice(rs.getString("price"));
				restaurant.setRating(rs.getDouble("rating"));
				// restaurant.setReviewsList(rs.getArray("reviewsList"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurants;
	}
}

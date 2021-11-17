package com.mie.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RestaurantList {
	
	private Map map = new HashMap();

	public void add(Restaurant newRestaurant) {
		map.put(newRestaurant.getId(), newRestaurant);
	}

	public boolean has(String restaurantId) {
		return map.containsKey(restaurantId);
	}

	public boolean has(Restaurant restaurant) {
		return map.containsKey(restaurant.getId());
	}

	public int size() {
		return map.size();
	}

	public Restaurant get(String restaurantId) throws NotFoundException {
		if (!has(restaurantId)) {
			throw new NotFoundException(restaurantId);
		}
		return (Restaurant) map.get(restaurantId);
	}

	public Iterator iterator() {
		return map.values().iterator();
	}
}

package com.restaurant.mvc.model.service;

import java.util.List;

import com.restaurant.mvc.model.dto.Restaurant;
import com.restaurant.mvc.model.dto.SearchCondition;

public interface RestaurantService {
	
	List<Restaurant> searchByCondition(SearchCondition condition);
	
	boolean registRestaurant(Restaurant restaurant);
	
	Restaurant searchById(int id);
	
	boolean modifyRestaurant(Restaurant restaurant);
}

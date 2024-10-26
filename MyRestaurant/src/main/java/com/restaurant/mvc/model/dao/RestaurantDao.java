package com.restaurant.mvc.model.dao;

import java.util.List;

import com.restaurant.mvc.model.dto.Restaurant;
import com.restaurant.mvc.model.dto.SearchCondition;

public interface RestaurantDao {
	
	List<Restaurant> selectByCondition(SearchCondition condition);
	
	int insertRestaurant(Restaurant restaurant);
	
	Restaurant selectById(int id);
	
	int updateRestaurant(Restaurant restaurant);
}

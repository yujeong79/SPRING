package com.restaurant.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.mvc.model.dao.RestaurantDao;
import com.restaurant.mvc.model.dto.Restaurant;
import com.restaurant.mvc.model.dto.SearchCondition;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	private RestaurantDao dao;
	
	public RestaurantServiceImpl(RestaurantDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Restaurant> searchByCondition(SearchCondition condition) {
		return dao.selectByCondition(condition);
	}

	@Override
	public boolean registRestaurant(Restaurant restaurant) {
		return dao.insertRestaurant(restaurant) > 0;
	}

	@Override
	public Restaurant searchById(int id) {
		return dao.selectById(id);
	}

	@Override
	public boolean modifyRestaurant(Restaurant restaurant) {
		return dao.updateRestaurant(restaurant) > 0;
	}

}

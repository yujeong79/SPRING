package com.ssafy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	private static DBUtil util = DBUtil.getInstance();
	
	// 싱글턴 /////////////////////////////////////////////////
	
	private UserDaoImpl() {}
	
	private static UserDao instance = new UserDaoImpl();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////////////////

	@Override
	public boolean insertUser(User user) {
		String sql = "INSERT INTO `User` (`id`, `password`, `name`) VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean success = false;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			
			success = pstmt.executeUpdate() > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}

		return success;
	}

	@Override
	public User login(User user) {
		User o = selectOne(user.getId());
		
		if(o.getPassword().equals(user.getPassword())) {
			return o;
		}
		
		return null;
	}

	@Override
	public List<User> selectAll() {
		List<User> users = new ArrayList<>();
		
		String sql = "SELECT * FROM `User`";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return users;
	}

	@Override
	public User selectOne(String id) {
		String sql = "SELECT * FROM `User` WHERE `id` = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				user = new User();
				
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return user;
	}

}

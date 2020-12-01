package com.csdj.mapper;

import java.util.List;

import com.csdj.pojo.User;

public interface UserMapper {
	public void insertUser(User user);

	public List<User> getAllUsers();

	public void updateUser(User user);

	public void deleteUser(Integer uid);

	public User querybyId(Integer uid);
}

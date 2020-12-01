package com.csdj.service;

import java.util.List;

import com.csdj.pojo.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
	public void insertUser(User user);

	public List<User> getAllUsers();

	public void updateUser(User user);

	public void deleteUser(Integer uid);

	public User querybyId(Integer uid);
	
	
	public PageInfo<User> getUserByPage(Integer pageNo,Integer pageSize);
}

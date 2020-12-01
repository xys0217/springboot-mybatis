package com.csdj.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csdj.mapper.UserMapper;
import com.csdj.pojo.User;
import com.csdj.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService{
	private Logger logger=Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("业务层执行查询方法.....");
		List<User> list=userMapper.getAllUsers();
		logger.info("返回集合的长度:"+list.size());
		return list;
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(Integer uid) {
		userMapper.deleteUser(uid);
	}

	@Override
	public User querybyId(Integer uid) {
		return userMapper.querybyId(uid);
	}

	@Override
	public PageInfo<User> getUserByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<User> list=userMapper.getAllUsers();
		PageInfo<User> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}
	

}


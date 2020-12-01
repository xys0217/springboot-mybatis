package com.csdj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csdj.pojo.User;
import com.csdj.service.UserService;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	/**
	 * 查询所有用户信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/userList")
	public String getAllUser(Model model) {
		List<User> list = userService.getAllUsers();
		model.addAttribute("list", list);
		return "user_list";
	}

	@RequestMapping("/sys")
	public String console(Model model) {
		return "test";
	}

	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping("/getUserByPage")
	public String getUserByPage(Integer pageNo, Integer pageSize, Model model) {
		if (pageNo == null || pageNo == 0) {
			pageNo = 1;
		}
		if (pageSize == null || pageSize == 0) {
			pageSize = 3;
		}
		PageInfo<User> pageInfo = userService.getUserByPage(pageNo, pageSize);
		model.addAttribute("page", pageInfo);
		return "user_page";
	}
	
	/**
	 * 页面跳转
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String  toAdd(@PathVariable String page) {
		return page;
	}
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String  toAdd(User user) {
		userService.insertUser(user);
		return "redirect:/user/userList";
	}
	
	/**
	 * 删除用户
	 * @param uid
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String  toAdd(Integer uid) {
		userService.deleteUser(uid);
		return "redirect:/user/userList";
	}
	
	/**
	 * 根据id查询用户信息
	 * @param uid
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryById")
	public String  queryById(Integer uid,Model model) {
		User user =  userService.querybyId(uid);
		model.addAttribute("user", user);
		return "update";
	}
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String  updateUser(User user) {
		userService.updateUser(user);
		return "redirect:/user/userList";
	}
	
}

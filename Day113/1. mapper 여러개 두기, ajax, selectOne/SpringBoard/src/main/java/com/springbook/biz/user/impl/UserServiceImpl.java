package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAOMybatis userDAO;
	
	public void setUserDAO(UserDAOMybatis userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	
	@Override
	public UserVO idCheck(UserVO vo) {
		return userDAO.idCheck(vo);		
	}

	@Override
	public void memberCount(UserVO vo) {
		int num = userDAO.memberCount(vo);
		System.out.println("회원수 " + num);
		
	}
	
	
}
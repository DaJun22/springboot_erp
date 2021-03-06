package com.dj.springboot_erp.modules.account.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.springboot_erp.modules.account.dao.UserDao;
import com.dj.springboot_erp.modules.account.entity.User;
import com.dj.springboot_erp.modules.account.service.UserService;
import com.dj.springboot_erp.modules.common.vo.Result;
import com.dj.springboot_erp.modules.common.vo.Result.ResultStatus;
import com.dj.springboot_erp.modules.common.vo.SearchVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Result insertUser(User user) {
		Result result = new Result(ResultStatus.SUCCESS.status, "");
		
		User userTemp = userDao.getUserByUserName(user.getUserName());
		if (userTemp != null) {
			result.setStatus(ResultStatus.FAILED.status);
			result.setMessage("User name is repeat.");
			return result;
		}
		
		user.setCreateDate(new Date());
		userDao.insertUser(user);
		
		return result;
	}

	@Override
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

	@Override
	public Result getUser(User user) {
		Result result = new Result(ResultStatus.SUCCESS.status, "");
		
		User userTemp = userDao.getUser(user);
		if (userTemp == null) {
			result.setStatus(ResultStatus.FAILED.status);
			result.setMessage("User name or password error.");
			return result;
		} else {
			result.setObject(userTemp);
		}
		
		return result;
	}

	@Override
	public PageInfo<User> getUsersBySearchVo(SearchVo searchVo) {
		searchVo.initSearchVo(searchVo);
		PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
		List<User> user = Optional.ofNullable(userDao.getUsersBySearchVo(searchVo)).orElse(Collections.emptyList());
		return new PageInfo<User>(user);
		
	}

	@Override
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public Result updateUser(User user) {	
	
		Result result = new Result(ResultStatus.SUCCESS.status, "");	
		User userTemp = userDao.getUserByUserName(user.getUserName());
		if (userTemp != null) {
			result.setStatus(ResultStatus.FAILED.status);
			result.setMessage("User name is repeat.");
			return result;
		}		
		userDao.updateUser(user);	
		return result;
	}

	@Override
	public Result deleteUser(int userId) {
		
		Result result = new Result(ResultStatus.SUCCESS.status, "");
		try {
			userDao.deleteUser(userId);
		} catch (Exception e) {
			result.setStatus(ResultStatus.FAILED.status);
			result.setMessage(e.getMessage());
			return result;
		}
		return result;
	}
}

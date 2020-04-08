package com.dj.springboot_erp.modules.account.service;

import com.dj.springboot_erp.modules.account.entity.User;
import com.dj.springboot_erp.modules.common.vo.Result;
import com.dj.springboot_erp.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;

public interface UserService {
	
		Result insertUser(User user);
		
		User getUserByUserName(String userName);
		
		Result getUser(User user);

		PageInfo<User> getUsersBySearchVo(SearchVo searchVo);
		
		User getUserById(int userId);
		
		Result updateUser(User user);
		
		Result deleteUser(int userId);
}

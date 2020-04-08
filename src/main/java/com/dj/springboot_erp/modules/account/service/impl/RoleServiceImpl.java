package com.dj.springboot_erp.modules.account.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.springboot_erp.modules.account.dao.RoleDao;
import com.dj.springboot_erp.modules.account.entity.Role;
import com.dj.springboot_erp.modules.account.service.RoleService;
import com.dj.springboot_erp.modules.common.vo.Result;
import com.dj.springboot_erp.modules.common.vo.Result.ResultStatus;
import com.dj.springboot_erp.modules.common.vo.SearchVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public Result insertRole(Role role) {
		
		Result result = new Result(ResultStatus.SUCCESS.status, "");
		roleDao.insertRole(role);
		return result;
	}

	@Override
	public PageInfo<Role> getRolesBySearchVo(SearchVo searchVo) {
		searchVo.initSearchVo(searchVo);
		PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
		List<Role> role = Optional.ofNullable(roleDao.getRolesBySearchVo(searchVo)).orElse(Collections.emptyList());
		return new PageInfo<Role>(role);
	}

}

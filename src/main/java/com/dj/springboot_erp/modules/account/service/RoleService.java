package com.dj.springboot_erp.modules.account.service;

import com.dj.springboot_erp.modules.account.entity.Role;
import com.dj.springboot_erp.modules.common.vo.Result;
import com.dj.springboot_erp.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;

public interface RoleService {
	
	Result insertRole(Role role);

	PageInfo<Role> getRolesBySearchVo(SearchVo searchVo);
}

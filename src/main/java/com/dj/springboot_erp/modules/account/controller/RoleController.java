package com.dj.springboot_erp.modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dj.springboot_erp.modules.account.entity.Role;
import com.dj.springboot_erp.modules.account.service.RoleService;
import com.dj.springboot_erp.modules.common.vo.Result;
import com.dj.springboot_erp.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/roleApi")
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@PostMapping(value = "/addRole", consumes = "application/json")
	public Result register(@RequestBody Role role) {
		return roleService.insertRole(role);
	}
	
	@PostMapping(value="/roles", consumes="application/json")
	public PageInfo<Role> getUsersBySearchVo(@RequestBody SearchVo searchVo) {
		return roleService.getRolesBySearchVo(searchVo);
	}

}

package com.dj.springboot_erp.modules.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	//登录页面
	@RequestMapping("/login")
	public String gotoLoginPage(ModelMap modelMap) {	
		return "indexSimple";
	}
	//主页
	@RequestMapping("/dashboard")
	public String dashboardPage() {
		return "index";
	}
	
	@RequestMapping("/users")
	public String usersPage() {
		return "index";
	}
	
	@RequestMapping("/roles")
	public String rolesPage() {
		return "index";
	}
	
	
}

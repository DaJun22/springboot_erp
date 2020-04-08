package com.dj.springboot_erp.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.dj.springboot_erp.modules.account.entity.Role;
import com.dj.springboot_erp.modules.account.entity.User;
import com.dj.springboot_erp.modules.common.vo.SearchVo;

@Mapper
@Repository
public interface RoleDao {
	@Insert("insert into t_role (role_name) "
			+ "values (#{roleName})")
	@Options(useGeneratedKeys=true, keyColumn="role_id", keyProperty="roleId")
	void insertRole(Role role);

	
	@Select("<script>" + 
			"select * from t_role "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ "and role_name like '%${keyWord}%' "
			+ "</if>"
			+ "</where>"
			+ "</script>")
	List<Role> getRolesBySearchVo(SearchVo searchVo);
}

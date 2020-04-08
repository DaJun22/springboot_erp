package com.dj.springboot_erp.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.dj.springboot_erp.modules.account.entity.User;
import com.dj.springboot_erp.modules.common.vo.SearchVo;

@Repository
@Mapper
public interface UserDao {
	
	@Insert("insert into t_user (user_name, password, create_date) "
			+ "values (#{userName}, #{password}, #{createDate})")
	@Options(useGeneratedKeys=true, keyColumn="user_id", keyProperty="userId")
	void insertUser(User user);
	
	@Select("select * from t_user where user_name = #{userName}")
	User getUserByUserName(String userName);
	
	@Select("select * from t_user where user_name=#{userName} and password=#{password}")
	User getUser(User user);
	
	@Select("<script>" + 
			"select * from t_user "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ "and user_name like '%${keyWord}%' "
			+ "</if>"
			+ "</where>"
			+ "<choose>"
			+ "<when test='orderBy != \"\" and orderBy != null'>"
			+ "order by ${orderBy} ${sort}"
			+ "</when>"
			+ "<otherwise>"
			+ "order by create_date desc"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script>")
	List<User> getUsersBySearchVo(SearchVo searchVo);
	
	@Select("select * from t_user where user_id=#{userId}")
	User getUserById(int userId);
	
	@Update("update t_user set user_name=#{userName} where user_id=#{userId}")
	void updateUser(User user);
	
	@Delete("delete from t_user where user_id=#{userId}")
	void deleteUser(int userId);

}

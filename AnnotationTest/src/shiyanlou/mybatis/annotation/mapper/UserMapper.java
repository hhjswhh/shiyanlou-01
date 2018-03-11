package shiyanlou.mybatis.annotation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import shiyanlou.mybatis.annotation.model.User;

public interface UserMapper {

	@Insert("insert into user(name,sex,age) values(#{name},#{sex},#{age})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public int insertUser(User user) throws Exception;
	
	 @Update("update user set age=#{age} where id=#{id}")
	    public void updateUser(User user) throws Exception;

	    @Delete("delete from user where id=#{user_id}")
	    public int deleteUser(@Param("user_id") Integer id) throws Exception;

	    @Select("select * from user where id=#{id}")
	    @Results({
	        @Result(id=true,property="id",column="id"),
	        @Result(property="name",column="name"),
	        @Result(property="sex",column="sex"),
	        @Result(property="age",column="age"),
	    })
	    public User selectUserById(Integer id) throws Exception;

	    @Select("select * from user")
	    public List<User> selectAllUser() throws Exception;

}

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org/DTD Mapper 3.0" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.shiyanlou.mybatis.mapper.UserMapper">
    <!-- 自定义返回结果集 -->
    <resultMap id="userMap" type="User">
        <id property="id" column="id" javaType="int"></id>
        <result property="username" column="username" javaType="String"></result>
        <result property="password" column="password" javaType="String"></result>
        <result property="sex" column="sex" javaType="String"></result>
        <result property="address" column="address" javaType="String"></result>
    </resultMap>

    <!-- 定义 SQL 语句，其中 id 需要和接口中的方法名一致 -->
    <!-- useGeneratedKeys：实现自动生成主键 -->
    <!-- keyProperty： 唯一标记一个属性 -->
    <!-- parameterType 指明查询时使用的参数类型，resultType 指明查询返回的结果集类型 -->
    <insert id="insertUser" useGeneratedKeys="true" keyProperty="id">
        insert into user (username,password,sex,address) values
        (#{username},#{password},#{sex},#{address})
    </insert>

    <update id="updateUser"  parameterType="User">
        update user set
        address=#{address} where
        id=#{id}
    </update>

    <delete id="deleteUser" parameterType="int">
        delete from user where
        id=#{id}
    </delete>

    <!-- 如未为 Java Bean 起类别名，resultType="com.shiyanlou.mybatis.model.User" -->

    <!-- 使用resultType时，一定要保证，你属性名与字段名相同；如果不相同，就使用resultMap -->
    <select id="selectUserById" parameterType="int" resultType="User">
        select * from user where id=#{id}
    </select>

    <select id="selectAllUser" resultMap="userMap">
        select * from user
    </select>

</mapper>

package shiyanlou.mybatis.onetoone.mapper;

import shiyanlou.mybatis.onetoone.model.Classes;

public interface ClassesMapper {
	public Classes selectClassById(Integer id) throws Exception;
}

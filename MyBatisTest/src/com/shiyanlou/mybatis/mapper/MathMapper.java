package com.shiyanlou.mybatis.mapper;

import java.util.List;

import com.shiyanlou.mybatis.model.Math;

public interface MathMapper {
	/**
	 * @param math
	 * @return
	 * @throws Exception
	 */
	public int insertMath(Math math) throws Exception;

	/**
	 * @param math
	 * @return
	 * @throws Exception
	 */
	public int updateMath(Math math) throws Exception;

	/**
	 * @param math
	 * @return
	 * @throws Exception
	 */
	public int deleteMath(String username) throws Exception;

	/**
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public Math selectMathByUsername(String username) throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	public List<Math> selectAllMath() throws Exception;
}

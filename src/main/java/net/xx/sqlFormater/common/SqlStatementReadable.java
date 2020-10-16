/*
 * Copyright (C) 2016 Lizhe Yan.
 * 
 * Author: Lizhe Yan <yanlizhe@sina.com>
 * 
 * This file is part of sql-formater.
 * 
 * sql-formater is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later 
 * version.
 * 
 * sql-formater is distributed in the hope that it will be 
 * useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
 * PURPOSE. See the GNU Lesser General Public License for more 
 * details.
 * 
 * You should have received a copy of the GNU Lesser General 
 * Public License along with sql-formater. 
 * If not, see <https://www.gnu.org/licenses/>.
 * 
 */

package net.xx.sqlFormater.common;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public interface SqlStatementReadable extends SqlStatement {
	
	/**
	 * 返回当前的可分页的sql语句
	 * @return sql语句
	 */
	public String getPagedSql();
	
	/**
	 * 返回当前的可分页的参数数组
	 * @param start 开始序号
	 * @param limit 结果集最大尺寸
	 * @return 参数数组
	 */
	public Object[] getArgs(int start, int limit);
	

	
	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public Byte queryByte();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public Short queryShort();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public Integer queryInteger();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public Long queryLong();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public Float queryFloat();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public Double queryDouble();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public String queryString();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public Date queryDate();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public <T> T queryObject(RowMapper<T> mapper);

	/**
	 * 执行查询语句并返回列表中的第一条数据作为查询结果
	 * @return 查询结果
	 */
	public Byte queryFirstByte();

	/**
	 * 执行查询语句并返回列表中的第一条数据作为查询结果
	 * @return 查询结果
	 */
	public Short queryFirstShort();

	/**
	 * 执行查询语句并返回列表中的第一条数据作为查询结果
	 * @return 查询结果
	 */
	public Integer queryFirstInteger();

	/**
	 * 执行查询语句并返回列表中的第一条数据作为查询结果
	 * @return 查询结果
	 */
	public Long queryFirstLong();

	/**
	 * 执行查询语句并返回列表中的第一条数据作为查询结果
	 * @return 查询结果
	 */
	public Float queryFirstFloat();

	/**
	 * 执行查询语句并返回列表中的第一条数据作为查询结果
	 * @return 查询结果
	 */
	public Double queryFirstDouble();

	/**
	 * 执行查询语句并返回列表中的第一条数据作为查询结果
	 * @return 查询结果
	 */
	public String queryFirstString();

	/**
	 * 执行查询语句并返回列表中的第一条数据作为查询结果
	 * @return 查询结果
	 */
	public Date queryFirstDate();

	/**
	 * 执行查询语句并返回列表中的第一条数据作为查询结果
	 * @return 查询结果
	 */
	public <T> T queryFirstObject(RowMapper<T> mapper);

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public List<Byte> queryByteList();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public List<Short> queryShortList();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public List<Integer> queryIntegerList();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public List<Long> queryLongList();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public List<Float> queryFloatList();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public List<Double> queryDoubleList();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public List<String> queryStringList();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public List<Date> queryDateList();

	/**
	 * 执行查询语句并返回查询结果
	 * @return 查询结果
	 */
	public <T> List<T> queryObjectList(RowMapper<T> mapper);

	/**
	 * 执行查询语句并返回分页的查询结果
	 * @return 查询结果
	 */
	public List<Byte> queryByteList(int start, int limit);

	/**
	 * 执行查询语句并返回分页的查询结果
	 * @return 查询结果
	 */
	public List<Short> queryShortList(int start, int limit);

	/**
	 * 执行查询语句并返回分页的查询结果
	 * @return 查询结果
	 */
	public List<Integer> queryIntegerList(int start, int limit);

	/**
	 * 执行查询语句并返回分页的查询结果
	 * @return 查询结果
	 */
	public List<Long> queryLongList(int start, int limit);

	/**
	 * 执行查询语句并返回分页的查询结果
	 * @return 查询结果
	 */
	public List<Float> queryFloatList(int start, int limit);

	/**
	 * 执行查询语句并返回分页的查询结果
	 * @return 查询结果
	 */
	public List<Double> queryDoubleList(int start, int limit);

	/**
	 * 执行查询语句并返回分页的查询结果
	 * @return 查询结果
	 */
	public List<String> queryStringList(int start, int limit);

	/**
	 * 执行查询语句并返回分页的查询结果
	 * @return 查询结果
	 */
	public List<Date> queryDateList(int start, int limit);

	/**
	 * 执行查询语句并返回分页的查询结果
	 * @return 查询结果
	 */
	public <T> List<T> queryObjectList(RowMapper<T> mapper, int start, int limit);

}

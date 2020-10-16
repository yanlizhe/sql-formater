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

package net.xx.sqlFormater.filter;

import java.util.Date;

import net.xx.sqlFormater.enumerate.ConditionType;

public interface InnerStandardConditionReadable {
	
	/**
	 * 在序列尾加入一个查询空内容的搜索条件
	 * @param table 表名
	 * @param column 列名
	 */
	public void pushNullCondition(String table, String column);
	
	/**
	 * 在序列尾加入一个查询非空内容的搜索条件
	 * @param table 表名
	 * @param column 列名
	 */
	public void pushNotNullCondition(String table, String column);
	
	/**
	 * 在序列尾加入一个自定义搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param statment 搜索条件
	 */
	public void pushCondition(String table, String column, String statment);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualByte(String table, String column, Byte value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualShort(String table, String column, Short value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualInteger(String table, String column, Integer value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualLong(String table, String column, Long value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualFloat(String table, String column, Float value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualDouble(String table, String column, Double value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualString(String table, String column, String value);
	
	/**
	 * 在序列尾加入一个搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param condition 条件
	 * @param value 值
	 */
	public void pushArgument(String table, String column, ConditionType condition, Object value);
	
	/**
	 * 在序列尾加入一个等于多个值之一的搜索条件（相当于in）
	 * @param table 表名
	 * @param column 列名
	 * @param values 值的数组
	 */
	public void pushArguments(String table, String column, Object[] values);
	
	/**
	 * 在序列尾加入一个多个数据列的其中一列等于输入值的搜索条件
	 * @param tables 表名的数组
	 * @param columns 列名的数组
	 * @param value 值
	 */
	public void pushArguments(String[] tables, String[] columns, Object value);
	
	/**
	 * 在序列尾加入一个模糊搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 搜索内容
	 */
	public void pushFuzzySearch(String table, String column, String value);
	
	/**
	 * 在序列尾加入一个多个数据列的其中一列符合模糊搜索内容的搜索条件
	 * @param tables 表名的数组
	 * @param columns 列名的数组
	 * @param value 搜索内容
	 */
	public void pushFuzzySearch(String[] tables, String[] columns, String value);
	
	/**
	 * 在序列尾加入一个等于一个具体日期的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 日期
	 */
	public void pushEqualDate(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个等于一个具体时间的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 时间
	 */
	public void pushEqualDateTime(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个大于等于一个具体日期的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 日期
	 */
	public void pushLargeThenDate(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个大于等于一个具体日期或为null的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 日期
	 */
	public void pushLargeThenDateAndNull(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个大于等于一个具体时间的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 时间
	 */
	public void pushLargeThenDateTime(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个大于等于一个具体时间或为null的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 时间
	 */
	public void pushLargeThenDateTimeAndNull(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个小于等于一个具体日期的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 日期
	 */
	public void pushSmallThenDate(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个小于等于一个具体日期或为null的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 日期
	 */
	public void pushSmallThenDateAndNull(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个小于等于一个具体时间的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 时间
	 */
	public void pushSmallThenDateTime(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个小于等于一个具体时间或为null的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param value 时间
	 */
	public void pushSmallThenDateTimeAndNull(String table, String column, Date value);
	
	/**
	 * 在序列尾加入一个大于开始日期且小于结束日期的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param start 开始日期
	 * @param end 结束日期
	 */
	public void pushBetweenDate(String table, String column, Date start, Date end);
	
	/**
	 * 在序列尾加入一个大于开始时间且小于结束时间的搜索条件
	 * @param table 表名
	 * @param column 列名
	 * @param start 开始时间
	 * @param end 结束时间
	 */
	public void pushBetweenDateTime(String table, String column, Date start, Date end);

}

package net.xx.sqlFormater.filter;

import java.util.Date;

import net.xx.sqlFormater.enumerate.ConditionType;

public interface InnerStandardConditionExecute {
	
	/**
	 * 在序列尾加入一个查询空内容的搜索条件
	 * @param column 列名
	 */
	public void pushNullCondition(String column);
	
	/**
	 * 在序列尾加入一个查询非空内容的搜索条件
	 * @param column 列名
	 */
	public void pushNotNullCondition(String column);
	
	/**
	 * 在序列尾加入一个自定义搜索条件
	 * @param column 列名
	 * @param statment 搜索条件
	 */
	public void pushCondition(String column, String statment);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualByte(String column, Byte value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualShort(String column, Short value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualInteger(String column, Integer value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualLong(String column, Long value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualFloat(String column, Float value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualDouble(String column, Double value);
	
	/**
	 * 在序列尾加入一个等于的搜索条件
	 * @param column 列名
	 * @param value 值
	 */
	public void pushEqualString(String column, String value);
	
	/**
	 * 在序列尾加入一个等于一个具体日期的搜索条件
	 * @param column 列名
	 * @param value 日期
	 */
	public void pushEqualDate(String column, Date value);
	
	/**
	 * 在序列尾加入一个等于一个具体时间的搜索条件
	 * @param column 列名
	 * @param value 时间
	 */
	public void pushEqualDateTime(String column, Date value);
	
	/**
	 * 在序列尾加入一个搜索条件
	 * @param column 列名
	 * @param condition 条件
	 * @param value 值
	 */
	public void pushArgument(String column, ConditionType condition, Object value);
	
	/**
	 * 在序列尾加入一个大于等于一个具体日期的搜索条件
	 * @param column 列名
	 * @param value 日期
	 */
	public void pushLargeThenDate(String column, Date value);
	
	/**
	 * 在序列尾加入一个大于等于一个具体时间的搜索条件
	 * @param column 列名
	 * @param value 时间
	 */
	public void pushLargeThenDateTime(String column, Date value);
	
	/**
	 * 在序列尾加入一个小于等于一个具体日期的搜索条件
	 * @param column 列名
	 * @param value 日期
	 */
	public void pushSmallThenDate(String column, Date value);
	
	/**
	 * 在序列尾加入一个小于等于一个具体时间的搜索条件
	 * @param column 列名
	 * @param value 时间
	 */
	public void pushSmallThenDateTime(String column, Date value);
	
	/**
	 * 在序列尾加入一个大于开始日期且小于结束日期的搜索条件
	 * @param column 列名
	 * @param start 开始日期
	 * @param end 结束日期
	 */
	public void pushBetweenDate(String column, Date start, Date end);
	
	/**
	 * 在序列尾加入一个大于开始时间且小于结束时间的搜索条件
	 * @param column 列名
	 * @param start 开始时间
	 * @param end 结束时间
	 */
	public void pushBetweenDateTime(String column, Date start, Date end);

}

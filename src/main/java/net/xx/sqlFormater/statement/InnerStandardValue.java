package net.xx.sqlFormater.statement;

import java.util.Date;

public interface InnerStandardValue {
	
	/**
	 * 将某一个数据列设为空
	 * @param column 列名
	 */
	public void setNullValue(String column);
	
	/**
	 * 将某一个数据列设为具体值
	 * @param column 列名
	 * @param value 值
	 */
	public void setValue(String column, Object value);
	
	/**
	 * 将某一个数据列设为具体值
	 * @param column 列名
	 * @param value 值
	 */
	public void setByteValue(String column, Byte value);
	
	/**
	 * 将某一个数据列设为具体值
	 * @param column 列名
	 * @param value 值
	 */
	public void setShortValue(String column, Short value);
	
	/**
	 * 将某一个数据列设为具体值
	 * @param column 列名
	 * @param value 值
	 */
	public void setIntegerValue(String column, Integer value);
	
	/**
	 * 将某一个数据列设为具体值
	 * @param column 列名
	 * @param value 值
	 */
	public void setLongValue(String column, Long value);
	
	/**
	 * 将某一个数据列设为具体值
	 * @param column 列名
	 * @param value 值
	 */
	public void setFloatValue(String column, Float value);
	
	/**
	 * 将某一个数据列设为具体值
	 * @param column 列名
	 * @param value 值
	 */
	public void setDoubleValue(String column, Double value);
	
	/**
	 * 将某一个数据列设为具体值
	 * @param column 列名
	 * @param value 值
	 */
	public void setStringValue(String column, String value);
	
	/**
	 * 将某一个数据列设为具体日期
	 * @param column 列名
	 * @param value 日期
	 */
	public void setDateValue(String column, Date value);
	
	/**
	 * 将某一个数据列设为当前时间
	 * @param column 列名
	 */
	public void setDateTimeValue(String column);
	
	/**
	 * 将某一个数据列设为具体时间
	 * @param column 列名
	 * @param value 时间
	 */
	public void setDateTimeValue(String column, Date value);
	
	/**
	 * 将某一个数据列设为当前时间戳
	 * @param column 列名
	 */
	public void setTimestampValue(String column);

}

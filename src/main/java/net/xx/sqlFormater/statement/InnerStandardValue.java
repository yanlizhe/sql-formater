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

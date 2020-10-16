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

package net.xx.sqlFormater.selector;

public interface InnerStandardSelector {

	/**
	 * 新增一个数据列的读取
	 * @param table 表名
	 * @param column 列名
	 * @param alias 别名
	 */
	public void pushSelection(String table, String column, String alias);

	/**
	 * 新增一个带公式的复杂读取
	 * @param operation 运算
	 * @param alias 别名
	 */
	public void pushOperationSelection(String operation, String alias);
	
	/**
	 * 在序列头插入分组项
	 * @param table 表名
	 * @param column 列名
	 */
	public void unshiftGroup(String table, String column);

	/**
	 * 在序列尾加入分组项
	 * @param table 表名
	 * @param column 列名
	 */
	public void pushGroup(String table, String column);

	/**
	 * 在序列头插入排序项，采用数据库默认排序规则
	 * @param table 表名
	 * @param column 列名
	 */
	public void unshiftSort(String table, String column);
	
	/**
	 * 在序列头插入排序项
	 * @param table 表名
	 * @param column 列名
	 * @param isAsc 是否升序排列
	 */
	public void unshiftSort(String table, String column, boolean isAsc);

	/**
	 * 在序列尾加入排序项，采用数据库默认排序规则
	 * @param table 表名
	 * @param column 列名
	 */
	public void pushSort(String table, String column);

	/**
	 * 在序列尾加入排序项
	 * @param table 表名
	 * @param column 列名
	 * @param isAsc 是否升序排列
	 */
	public void pushSort(String table, String column, boolean isAsc);

}

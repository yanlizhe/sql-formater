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

public interface InnerGeneralSelector {
	
	/**
	 * 新增一个别名
	 * @param sql sql语句片段
	 */
	public void pushRawAlias(String sql);

	/**
	 * 新增一个任意内容的数据列
	 * @param sql sql语句片段
	 */
	public void pushRawSelection(String sql);
	
	/**
	 * 在序列头插入分组内容
	 * @param sql sql语句片段
	 */
	public void unshiftRawGroup(String sql);

	/**
	 * 在序列尾加入分组内容
	 * @param sql sql语句片段
	 */
	public void pushRawGroup(String sql);

	/**
	 * 在序列头插入排序内容
	 * @param sql sql语句片段
	 */
	public void unshiftRawSort(String sql);

	/**
	 * 在序列尾加入排序内容
	 * @param sql sql语句片段
	 */
	public void pushRawSort(String sql);

}

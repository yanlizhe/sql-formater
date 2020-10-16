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

public interface InnerGeneralCondition {
	
	/**
	 * 在序列尾加入一个查询条件
	 * @param sql sql语句片段
	 */
	public void pushRawCondition(String sql);
	
	/**
	 * 在序列尾加入一个参数
	 * @param arg 参数
	 */
	public void pushRawArg(Object arg);
	
	/**
	 * 将多个参数合并到本SQL的参数序列中
	 * @param args 参数数组
	 */
	public void mergeRawArg(Object[] args);

}

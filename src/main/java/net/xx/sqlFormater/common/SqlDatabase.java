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

public interface SqlDatabase {
	
	/**
	 * 判断索引是否存在
	 * @param indexName 索引名称
	 * @return 如果存在返回<code>true</code>，如果不存在返回<code>false</code>
	 */
	public boolean hasIndex(String indexName);
	
	/**
	 * 判断表是否存在
	 * @param tableName 表名称
	 * @return 如果存在返回<code>true</code>，如果不存在返回<code>false</code>
	 */
	public boolean hasTable(String tableName);
	
	/**
	 * 判断视图是否存在
	 * @param viewName 视图名称
	 * @return 如果存在返回<code>true</code>，如果不存在返回<code>false</code>
	 */
	public boolean hasView(String viewName);

}

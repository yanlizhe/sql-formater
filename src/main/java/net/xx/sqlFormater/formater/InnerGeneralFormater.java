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

package net.xx.sqlFormater.formater;

public interface InnerGeneralFormater {
	
	/**
	 * 获取前引用符号
	 * @return 前引用符号
	 */
	public String getOpenQuote();
	
	/**
	 * 获取后引用符号
	 * @return 后引用符号
	 */
	public String getCloseQuote();
	
	/**
	 * 获取被引用的内容
	 * @param text 内容
	 * @return 被引用的内容
	 */
	public String quoted(String text);
	
	/**
	 * 获取被引用的数据列
	 * @param table 表名
	 * @param column 列名
	 * @return 被引用的数据列
	 */
	public String quoted(String table, String column);

}

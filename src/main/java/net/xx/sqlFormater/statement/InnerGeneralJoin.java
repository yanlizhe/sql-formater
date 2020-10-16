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

import net.xx.sqlFormater.util.JoinStatement;

public interface InnerGeneralJoin {
	
	/**
	 * 在序列头插入一个合并查询
	 * @param key 关键字
	 * @param sql sql语句片段
	 */
	public void unshiftRawJoin(String key, String sql);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param key 关键字
	 * @param sql sql语句片段
	 */
	public void pushRawJoin(String key, String sql);
	
	/**
	 * 根据关键字查询合并查询内容
	 * @param key 关键字
	 * @return 合并查询
	 */
	public JoinStatement getRawJoin(String key);
	
	/**
	 * 更新某关键字的sql语句片段
	 * @param key 关键字
	 * @param sql sql语句片段
	 */
	public void refreshRawJoin(String key, String sql);

}

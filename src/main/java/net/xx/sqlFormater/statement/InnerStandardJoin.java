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

import net.xx.sqlFormater.enumerate.JoinType;

public interface InnerStandardJoin {

	/**
	 * 在序列头插入一个合并查询
	 * @param joinTable 需要关联的表名
	 * @param joinColumn 关联的表的列名
	 * @param refTable 关联到的表名
	 * @param refColumn 关联到的表的列
	 */
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn);
	
	/**
	 * 在序列头插入一个合并查询
	 * @param joinTable 需要关联的表名
	 * @param joinColumn 关联的表的列名
	 * @param refTable 关联到的表名
	 * @param refColumn 关联到的表的列
	 * @param alias 别名
	 */
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias);
	
	/**
	 * 在序列头插入一个合并查询
	 * @param joinType 联合类型
	 * @param joinTable 需要关联的表名
	 * @param joinColumn 关联的表的列名
	 * @param refTable 关联到的表名
	 * @param refColumn 关联到的表的列
	 */
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn);
	
	/**
	 * 在序列头插入一个合并查询
	 * @param joinType 联合类型
	 * @param joinTable 需要关联的表名
	 * @param joinColumn 关联的表的列名
	 * @param refTable 关联到的表名
	 * @param refColumn 关联到的表的列
	 * @param alias 别名
	 */
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn, String alias);
	
	/**
	 * 在序列头插入一个合并查询
	 * @param joinTable 需要关联的表名
	 * @param joinColumns 关联的表的列名数组
	 * @param refTable 关联到的表名
	 * @param refColumns 关联到的表的列名数组
	 */
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns);
	
	/**
	 * 在序列头插入一个合并查询
	 * @param joinTable 需要关联的表名
	 * @param joinColumns 关联的表的列名数组
	 * @param refTable 关联到的表名
	 * @param refColumns 关联到的表的列名数组
	 * @param alias 别名
	 */
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias);
	
	/**
	 * 在序列头插入一个合并查询
	 * @param joinType 联合类型
	 * @param joinTable 需要关联的表名
	 * @param joinColumns 关联的表的列名数组
	 * @param refTable 关联到的表名
	 * @param refColumns 关联到的表的列名数组
	 */
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns);
	
	/**
	 * 在序列头插入一个合并查询
	 * @param joinType 联合类型
	 * @param joinTable 需要关联的表名
	 * @param joinColumns 关联的表的列名数组
	 * @param refTable 关联到的表名
	 * @param refColumns 关联到的表的列名数组
	 * @param alias 别名
	 */
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param joinTable 需要关联的表名
	 * @param joinColumn 关联的表的列名
	 * @param refTable 关联到的表名
	 * @param refColumn 关联到的表的列
	 */
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param joinTable 需要关联的表名
	 * @param joinColumn 关联的表的列名
	 * @param refTable 关联到的表名
	 * @param refColumn 关联到的表的列
	 * @param alias 别名
	 */
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param joinType 联合类型
	 * @param joinTable 需要关联的表名
	 * @param joinColumn 关联的表的列名
	 * @param refTable 关联到的表名
	 * @param refColumn 关联到的表的列
	 */
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param joinType 联合类型
	 * @param joinTable 需要关联的表名
	 * @param joinColumn 关联的表的列名
	 * @param refTable 关联到的表名
	 * @param refColumn 关联到的表的列
	 * @param alias 别名
	 */
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn, String alias);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param joinTable 需要关联的表名
	 * @param joinColumns 关联的表的列名数组
	 * @param refTable 关联到的表名
	 * @param refColumns 关联到的表的列名数组
	 */
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param joinTable 需要关联的表名
	 * @param joinColumns 关联的表的列名数组
	 * @param refTable 关联到的表名
	 * @param refColumns 关联到的表的列名数组
	 * @param alias 别名
	 */
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param joinType 联合类型
	 * @param joinTable 需要关联的表名
	 * @param joinColumns 关联的表的列名数组
	 * @param refTable 关联到的表名
	 * @param refColumns 关联到的表的列名数组
	 */
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param joinType 联合类型
	 * @param joinTable 需要关联的表名
	 * @param joinColumns 关联的表的列名数组
	 * @param refTable 关联到的表名
	 * @param refColumns 关联到的表的列名数组
	 * @param alias 别名
	 */
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias);

}

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

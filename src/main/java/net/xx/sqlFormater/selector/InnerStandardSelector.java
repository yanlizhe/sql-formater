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

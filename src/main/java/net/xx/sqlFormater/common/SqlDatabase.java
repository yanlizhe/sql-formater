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

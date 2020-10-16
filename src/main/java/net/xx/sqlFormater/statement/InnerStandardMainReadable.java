package net.xx.sqlFormater.statement;

public interface InnerStandardMainReadable extends InnerStandardMain {
	
	/**
	 * 设置当前SQL语句的主表
	 * @param table 表名
	 * @param alias 别名
	 */
	public void setTable(String table, String alias);

}

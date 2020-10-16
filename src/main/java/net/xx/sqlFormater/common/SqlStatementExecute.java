package net.xx.sqlFormater.common;

public interface SqlStatementExecute extends SqlStatement {
	
	/**
	 * 执行SQL语句
	 * @return 被影响到的数据条数
	 */
	public int execute();

}

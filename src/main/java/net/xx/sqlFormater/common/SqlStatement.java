package net.xx.sqlFormater.common;

public interface SqlStatement {
	
	public void pretreatment();
	
	/**
	 * 返回当前的sql语句
	 * @return sql语句
	 */
	public String getSql();
	
	/**
	 * 返回当前的参数数组
	 * @return 参数数组
	 */
	public Object[] getArgs();

}

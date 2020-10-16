package net.xx.sqlFormater.statement;

public interface BaseMain {
	
	/**
	 * 设置当前SQL语句的主表
	 * @param sql sql语句片段
	 */
	public void setBaseFrom(String sql);
	
	/**
	 * 获取当前SQL语句的主表
	 * @return 主表
	 */
	public String getBaseFrom();

}

package net.xx.sqlFormater.filter;

public interface InnerGeneralCondition {
	
	/**
	 * 在序列尾加入一个查询条件
	 * @param sql sql语句片段
	 */
	public void pushRawCondition(String sql);
	
	/**
	 * 在序列尾加入一个参数
	 * @param arg 参数
	 */
	public void pushRawArg(Object arg);
	
	/**
	 * 将多个参数合并到本SQL的参数序列中
	 * @param args 参数数组
	 */
	public void mergeRawArg(Object[] args);

}

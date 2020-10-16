package net.xx.sqlFormater.statement;

public interface InnerGeneralMainReadable {
	
	/**
	 * 设置当前SQL语句的主表
	 * @param key 关键字
	 * @param sql sql语句片段
	 */
	public void setRawFrom(String key, String sql);

}

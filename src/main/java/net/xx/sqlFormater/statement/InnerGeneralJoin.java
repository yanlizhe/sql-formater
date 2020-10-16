package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.util.JoinStatement;

public interface InnerGeneralJoin {
	
	/**
	 * 在序列头插入一个合并查询
	 * @param key 关键字
	 * @param sql sql语句片段
	 */
	public void unshiftRawJoin(String key, String sql);
	
	/**
	 * 在序列尾加入一个合并查询
	 * @param key 关键字
	 * @param sql sql语句片段
	 */
	public void pushRawJoin(String key, String sql);
	
	/**
	 * 根据关键字查询合并查询内容
	 * @param key 关键字
	 * @return 合并查询
	 */
	public JoinStatement getRawJoin(String key);
	
	/**
	 * 更新某关键字的sql语句片段
	 * @param key 关键字
	 * @param sql sql语句片段
	 */
	public void refreshRawJoin(String key, String sql);

}

package net.xx.sqlFormater.selector;

public interface InnerGeneralSelector {
	
	/**
	 * 新增一个别名
	 * @param sql sql语句片段
	 */
	public void pushRawAlias(String sql);

	/**
	 * 新增一个任意内容的数据列
	 * @param sql sql语句片段
	 */
	public void pushRawSelection(String sql);
	
	/**
	 * 在序列头插入分组内容
	 * @param sql sql语句片段
	 */
	public void unshiftRawGroup(String sql);

	/**
	 * 在序列尾加入分组内容
	 * @param sql sql语句片段
	 */
	public void pushRawGroup(String sql);

	/**
	 * 在序列头插入排序内容
	 * @param sql sql语句片段
	 */
	public void unshiftRawSort(String sql);

	/**
	 * 在序列尾加入排序内容
	 * @param sql sql语句片段
	 */
	public void pushRawSort(String sql);

}

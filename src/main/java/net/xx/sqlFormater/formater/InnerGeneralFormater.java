package net.xx.sqlFormater.formater;

public interface InnerGeneralFormater {
	
	/**
	 * 获取前引用符号
	 * @return 前引用符号
	 */
	public String getOpenQuote();
	
	/**
	 * 获取后引用符号
	 * @return 后引用符号
	 */
	public String getCloseQuote();
	
	/**
	 * 获取被引用的内容
	 * @param text 内容
	 * @return 被引用的内容
	 */
	public String quoted(String text);
	
	/**
	 * 获取被引用的数据列
	 * @param table 表名
	 * @param column 列名
	 * @return 被引用的数据列
	 */
	public String quoted(String table, String column);

}

package net.xx.sqlFormater.database;

import net.xx.sqlFormater.common.SqlDatabase;

public interface GeneralDatabase extends SqlDatabase, PackageDatabase {

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

}

package net.xx.sqlFormater.database.dialec.kingbase;

import net.xx.sqlFormater.database.dialec.AbsDatabase;

public class KingbaseDatabaseBean extends AbsDatabase {

	public KingbaseDatabaseBean(String jdbcTemplate) {
		super(jdbcTemplate);
	}

	public static final String PATTERN_DATE = "yyyy-MM-dd";

	public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

	@Override
	public String getOpenQuote() {
		return "\"";
	}

	@Override
	public String getCloseQuote() {
		return "\"";
	}

	@Override
	public boolean hasIndex(String indexName) {
		if (getSpringJdbc().queryForObject(
				"select count(1) from SYS_CLASS where RELKIND = ? and RELNAME = ?", 
				new Object[]{'i', indexName}, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasTable(String tableName) {
		if (getSpringJdbc().queryForObject(
				"select count(1) from SYS_TYPE where TYPNAME = ?", 
				new Object[]{tableName}, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasView(String viewName) {
		if (getSpringJdbc().queryForObject(
				"select count(1) from SYS_CLASS where RELKIND = ? and RELNAME = ?", 
				new Object[]{'v', viewName}, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

}

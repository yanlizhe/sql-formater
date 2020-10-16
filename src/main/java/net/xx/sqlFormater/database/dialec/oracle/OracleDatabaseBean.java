package net.xx.sqlFormater.database.dialec.oracle;

import net.xx.sqlFormater.database.dialec.AbsDatabase;

public final class OracleDatabaseBean extends AbsDatabase {

	public OracleDatabaseBean(String jdbcTemplate) {
		super(jdbcTemplate);
	}

	public static final String PATTERN_DATE = "yyyyMMdd";
	public static final String FORMAT_DATE = "yyyymmdd";

	public static final String PATTERN_DATETIME = "yyyyMMddHHmmss";
	public static final String FORMAT_DATETIME = "yyyymmddhh24miss";

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
				"select count(1) from USER_INDEXES where INDEX_NAME = ?", 
				new Object[]{indexName}, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasTable(String tableName) {
		if (getSpringJdbc().queryForObject(
				"select count(1) from USER_TABLES where TABLE_NAME = ?", 
				new Object[]{tableName}, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasView(String viewName) {
		if (getSpringJdbc().queryForObject(
				"select count(1) from USER_VIEWS where VIEW_NAME = ?", 
				new Object[]{viewName}, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

}

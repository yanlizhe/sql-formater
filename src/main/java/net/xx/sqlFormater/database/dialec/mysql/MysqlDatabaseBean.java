package net.xx.sqlFormater.database.dialec.mysql;

import net.xx.sqlFormater.database.dialec.AbsDatabase;

public final class MysqlDatabaseBean extends AbsDatabase {

	public MysqlDatabaseBean(String jdbcTemplate) {
		super(jdbcTemplate);
	}

	public static final String PATTERN_DATE = "yyyyMMdd";
	public static final String FORMAT_DATE = "%Y%m%d";

	public static final String PATTERN_DATETIME = "yyyyMMddHHmmss";
	public static final String FORMAT_DATETIME = "%Y%m%d%H%i%s";

	@Override
	public String getOpenQuote() {
		return "`";
	}

	@Override
	public String getCloseQuote() {
		return "`";
	}

	@Override
	public boolean hasIndex(String indexName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasTable(String tableName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasView(String viewName) {
		// TODO Auto-generated method stub
		return false;
	}

}

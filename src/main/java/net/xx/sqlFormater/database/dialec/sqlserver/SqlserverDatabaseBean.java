package net.xx.sqlFormater.database.dialec.sqlserver;

import net.xx.sqlFormater.database.dialec.AbsDatabase;

public class SqlserverDatabaseBean extends AbsDatabase {

	public SqlserverDatabaseBean(String jdbcTemplate) {
		super(jdbcTemplate);
	}
	
//	public static final String FORMAT_STYLE = "120";

	public static final String PATTERN_DATE = "yyyy-MM-dd";
//	public static final String TYPE_DATE = "varchar(10)";

	public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
//	public static final String TYPE_DATETIME = "varchar(19)";

	public static final String PATTERN_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";
//	public static final String TYPE_TIMESTAMP = "varchar(23)";

	@Override
	public String getOpenQuote() {
		return "[";
	}

	@Override
	public String getCloseQuote() {
		return "]";
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

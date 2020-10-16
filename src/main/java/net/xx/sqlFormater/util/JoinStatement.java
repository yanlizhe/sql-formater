package net.xx.sqlFormater.util;

public final class JoinStatement {
	
	private String key;
	
	private String sql;

	public JoinStatement(String key, String sql) {
		this.key = key;
		this.sql = sql;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}

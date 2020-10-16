package net.xx.sqlFormater.util;

public enum DbType {
	
	MYSQL("mysql"), 
	
	SQLSERVER("sqlserver"), 
	
	ORACLE("oracle"), 
	
	KINGBASE("kingbase");
	
	private String mValue;
	
	DbType(String value) {
		mValue = value;
	}

	public String getValue() {
		return mValue;
	}
	
	public static DbType getInstance(String value) {
		if(null != value) {
			switch(value.toLowerCase()) {
			case "sqlserver": return SQLSERVER;
			case "oracle": return ORACLE;
			case "kingbase": return KINGBASE;
			default: 
				return MYSQL;
			}
		}
		return null;
	}

}

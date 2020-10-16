package net.xx.sqlFormater.common;

import java.util.List;

public interface SqlFormaterInsert extends SqlFormater {
	
	public String getSql(String table, List<String> columns, List<String> values);

}

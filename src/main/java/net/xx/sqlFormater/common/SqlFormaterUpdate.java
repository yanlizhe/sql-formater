package net.xx.sqlFormater.common;

import java.util.List;

public interface SqlFormaterUpdate extends SqlFormater {
	
	public Object[] getArgs(List<Object> values, List<Object> args);
	
	public String getSql(String table, List<String> sets, List<String> conditions);

}

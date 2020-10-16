package net.xx.sqlFormater.common;

import java.util.List;

public interface SqlFormaterRead extends SqlFormater {
	
	public String getSql(List<String> selection, String from, List<String> join, List<String> condition, List<String> groups, List<String> sort);
	
	public String getPagedSql(List<String> alias, List<String> selection, String from, List<String> join, List<String> condition, List<String> groups, List<String> sort);
	
	public Object[] getArgs(List<Object> args, int start, int size);

}

package net.xx.sqlFormater.common;

import java.util.List;

public interface SqlFormaterDelete extends SqlFormater {
	
	public String getSql(String table, List<String> conditions);

}

package net.xx.sqlFormater.formater.dialec.mysql;

import java.util.LinkedList;
import java.util.List;

import net.xx.sqlFormater.formater.dialec.AbsFormaterRead;

public class MysqlFormaterReadBean extends AbsFormaterRead {

	public MysqlFormaterReadBean(String database) {
		super(database);
	}

	@Override
	public String getPagedSql(List<String> alias, List<String> selection, 
			String from, List<String> join, List<String> condition, 
			List<String> group, List<String> sort) {
		StringBuilder result = new StringBuilder();
		
		result = appendSqlBuilder(result, selection, from, 
				join, condition, group, sort);
		result.append(" limit ?, ?");
		
		return result.toString();
	}

	@Override
	public Object[] getArgs(List<Object> args, int start, int size) {
		final LinkedList<Object> result = new LinkedList<Object>();
		if (null != args && args.size() > 0) {
			result.addAll(args);
		}
		result.add(start);
		result.add(size);
		return result.toArray();
	}

}

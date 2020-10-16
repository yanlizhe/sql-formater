package net.xx.sqlFormater.formater.dialec;

import java.util.LinkedList;
import java.util.List;

import net.xx.sqlFormater.formater.GeneralFormaterUpdate;

public final class FormaterUpdateBean extends AbsFormater implements GeneralFormaterUpdate {
	
	public FormaterUpdateBean(String database) {
		super(database);
	}

	@Override
	@Deprecated
	public final Object[] getArgs(List<Object> args) {
		return super.getArgs(args);
	}

	@Override
	public Object[] getArgs(List<Object> sets, List<Object> args) {
		final LinkedList<Object> result = new LinkedList<Object>();
		if (null != sets) {
			result.addAll(sets);
		}
		if (null != args) {
			result.addAll(args);
		}
		return result.toArray();
	}

	@Override
	public String getSql(String table, List<String> sets, List<String> conditions) {
		final StringBuilder result = new StringBuilder();
		
		result.append("update ");
		result.append(table);
		
		if(null != sets && sets.size() > 0) {
			result.append(" set ");
			result.append(join(sets, ", "));
		}
		
		if(null != conditions && conditions.size() > 0) {
			result.append(" where ");
			result.append(join(conditions, " and "));
		}
		
		return result.toString();
	}

}

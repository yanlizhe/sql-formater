package net.xx.sqlFormater.formater.dialec;

import java.util.List;

import net.xx.sqlFormater.formater.GeneralFormaterDelete;

public final class FormaterDeleteBean extends AbsFormater implements GeneralFormaterDelete {
	
	public FormaterDeleteBean(String database) {
		super(database);
	}

	@Override
	public String getSql(String table, List<String> conditions) {
		final StringBuilder result = new StringBuilder();
		
		result.append("delete from ");
		result.append(table);
		
		if(null != conditions && conditions.size() > 0) {
			result.append(" where ");
			result.append(join(conditions, " and "));
		}
		
		return result.toString();
	}

}

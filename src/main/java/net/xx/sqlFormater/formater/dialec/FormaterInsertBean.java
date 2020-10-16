package net.xx.sqlFormater.formater.dialec;

import java.util.List;

import net.xx.sqlFormater.formater.GeneralFormaterInsert;

public final class FormaterInsertBean extends AbsFormater implements GeneralFormaterInsert {
	
	public FormaterInsertBean(String database) {
		super(database);
	}

	@Override
	public String getSql(String table, List<String> columns, List<String> values) {
		final StringBuilder result = new StringBuilder();
		
		result.append("insert into ");
		result.append(table);
		result.append(" (");
		if(null != columns && columns.size() > 0) {
			result.append(join(columns, ", "));
		}
		result.append(") values (");
		if(null != values && values.size() > 0) {
			result.append(join(values, ", "));
		}
		result.append(")");
		
		return result.toString();
	}

}

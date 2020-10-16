/*
 * Copyright (C) 2016 Lizhe Yan.
 * 
 * Author: Lizhe Yan <yanlizhe@sina.com>
 * 
 * This file is part of sql-formater.
 * 
 * sql-formater is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later 
 * version.
 * 
 * sql-formater is distributed in the hope that it will be 
 * useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
 * PURPOSE. See the GNU Lesser General Public License for more 
 * details.
 * 
 * You should have received a copy of the GNU Lesser General 
 * Public License along with sql-formater. 
 * If not, see <https://www.gnu.org/licenses/>.
 * 
 */

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

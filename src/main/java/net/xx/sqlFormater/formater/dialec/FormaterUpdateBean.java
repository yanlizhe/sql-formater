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

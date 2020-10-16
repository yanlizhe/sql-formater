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

import net.xx.sqlFormater.formater.GeneralFormaterRead;

public abstract class AbsFormaterRead extends AbsFormater implements GeneralFormaterRead {

	protected AbsFormaterRead(String database) {
		super(database);
	}

	@Override
	public String getSql(List<String> selection, String from, List<String> join, 
			List<String> condition, List<String> group, List<String> sort) {
		return appendSqlBuilder(new StringBuilder(), selection, from, 
				join, condition, group, sort).toString();
	}
	
	protected StringBuilder appendSqlBuilder(StringBuilder result, 
			List<String> selection, String from, List<String> join, 
			List<String> condition, List<String> group, List<String> sort) {
		result.append("select ");
		if(null != selection && selection.size() > 0) {
			result.append(join(selection, ", "));
		} else {
			result.append("*");
		}
		result.append(" from ");
		result.append(from);
		
		if(null != join && join.size() > 0) {
			result.append(" ");
			result.append(join(join, " "));
		}
		
		if(null != condition && condition.size() > 0) {
			result.append(" where ");
			result.append(join(condition, " and "));
		}
		
		if(null != group && group.size() > 0) {
			result.append(" group by ");
			result.append(join(group, ", "));
		}
		
		if(null != sort && sort.size() > 0) {
			result.append(" order by ");
			result.append(join(sort, ", "));
		}
		
		return result;
	}

}

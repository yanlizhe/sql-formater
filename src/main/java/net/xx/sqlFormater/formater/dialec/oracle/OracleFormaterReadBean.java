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

package net.xx.sqlFormater.formater.dialec.oracle;

import java.util.LinkedList;
import java.util.List;

import net.xx.sqlFormater.formater.dialec.AbsFormaterRead;

public final class OracleFormaterReadBean extends AbsFormaterRead {

	public OracleFormaterReadBean(String database) {
		super(database);
	}

	@Override
	public String getPagedSql(List<String> alias, List<String> selection, 
			String from, List<String> join, List<String> condition, 
			List<String> group, List<String> sort) {
		StringBuilder result = new StringBuilder();
		
		result.append("select ");
		if(null != alias && alias.size() > 0) {
			result.append(join(alias, ", "));
		} else {
			result.append("*");
		}
		result.append(" from (select ");
		if(null != alias && alias.size() > 0) {
			for (int i = 0, s = alias.size(); i < s; i++) {
				result.append(getOpenQuote());
				result.append("_dat");
				result.append(getCloseQuote());
				result.append(".");
				result.append(alias.get(i));
				result.append(", ");
			}
		} else {
			result.append(getOpenQuote());
			result.append("_dat");
			result.append(getCloseQuote());
			result.append(".*, ");
		}
		result.append("rownum as ");
		result.append(getOpenQuote());
		result.append("_rn");
		result.append(getCloseQuote());
		result.append(" from (");
		result = appendSqlBuilder(result, selection, from, 
				join, condition, group, sort);
		result.append(") ");
		result.append(getOpenQuote());
		result.append("_dat");
		result.append(getCloseQuote());
		result.append(" where rownum < ?) where ");
		result.append(getOpenQuote());
		result.append("_rn");
		result.append(getCloseQuote());
		result.append(" > ?");
		
		return result.toString();
	}

	@Override
	public Object[] getArgs(List<Object> args, int start, int size) {
		final LinkedList<Object> result = new LinkedList<Object>();
		if (null != args && args.size() > 0) {
			result.addAll(args);
		}
		result.add(start + size + 1);
		result.add(start);
		return result.toArray();
	}

}

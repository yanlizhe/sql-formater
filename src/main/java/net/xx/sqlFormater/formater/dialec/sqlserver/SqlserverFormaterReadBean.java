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

package net.xx.sqlFormater.formater.dialec.sqlserver;

import java.util.LinkedList;
import java.util.List;

import net.xx.sqlFormater.formater.dialec.AbsFormaterRead;

public final class SqlserverFormaterReadBean extends AbsFormaterRead {

	public SqlserverFormaterReadBean(String database) {
		super(database);
	}

	@Override
	public String getPagedSql(List<String> alias, List<String> selection, String from, List<String> join,
			List<String> condition, List<String> group, List<String> sort) {
		StringBuilder result = new StringBuilder();

		result = appendSqlBuilder(result, selection, from, 
				join, condition, group, sort);
		result.append(" offset ? rows fetch next ? rows only");
		
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

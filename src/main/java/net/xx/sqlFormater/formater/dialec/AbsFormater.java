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

import java.util.Iterator;
import java.util.List;

import org.springframework.util.StringUtils;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.database.GeneralDatabase;
import net.xx.sqlFormater.formater.GeneralFormater;

abstract class AbsFormater implements GeneralFormater {
	
	protected AbsFormater(String database) {
		if(SqlBeanFactory.hasName(database)) {
			setGeneralDatabase(SqlBeanFactory.getBean(database, GeneralDatabase.class));
		}
	}
	
	private GeneralDatabase mGeneralDatabase;

	@Override
	public GeneralDatabase getGeneralDatabase() {
		return mGeneralDatabase;
	}

	@Override
	public void setGeneralDatabase(GeneralDatabase generalDatabase) {
		mGeneralDatabase = generalDatabase;
	}

	@Override
	public final String getOpenQuote() {
		return getGeneralDatabase().getOpenQuote();
	}

	@Override
	public final String getCloseQuote() {
		return getGeneralDatabase().getCloseQuote();
	}

	@Override
	public String quoted(String text) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(text);
		sql.append(getCloseQuote());
		return sql.toString();
	}

	@Override
	public String quoted(String table, String column) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		return sql.toString();
	}

	@Override
	public Object[] getArgs(List<Object> args) {
		if (null == args) {
			return new Object[0];
		} else {
			return args.toArray();
		}
	}
	
	protected static String join(List<String> list, String separator) {
		final StringBuilder result = new StringBuilder();
		final Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			if(!StringUtils.isEmpty(str)) {
				if(null != separator && result.length() > 0) {
					result.append(separator);
				}
				result.append(str);
			}
		}
		return result.toString();
	}

}

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

package net.xx.sqlFormater.database.dialec.oracle;

import net.xx.sqlFormater.database.dialec.AbsDatabase;

public final class OracleDatabaseBean extends AbsDatabase {

	public OracleDatabaseBean(String jdbcTemplate) {
		super(jdbcTemplate);
	}

	public static final String PATTERN_DATE = "yyyyMMdd";
	public static final String FORMAT_DATE = "yyyymmdd";

	public static final String PATTERN_DATETIME = "yyyyMMddHHmmss";
	public static final String FORMAT_DATETIME = "yyyymmddhh24miss";

	@Override
	public String getOpenQuote() {
		return "\"";
	}

	@Override
	public String getCloseQuote() {
		return "\"";
	}

	@Override
	public boolean hasIndex(String indexName) {
		if (getSpringJdbc().queryForObject(
				"select count(1) from USER_INDEXES where INDEX_NAME = ?", 
				new Object[]{indexName}, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasTable(String tableName) {
		if (getSpringJdbc().queryForObject(
				"select count(1) from USER_TABLES where TABLE_NAME = ?", 
				new Object[]{tableName}, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasView(String viewName) {
		if (getSpringJdbc().queryForObject(
				"select count(1) from USER_VIEWS where VIEW_NAME = ?", 
				new Object[]{viewName}, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

}

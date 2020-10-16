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

package net.xx.sqlFormater.database.dialec.sqlserver;

import net.xx.sqlFormater.database.dialec.AbsDatabase;

public class SqlserverDatabaseBean extends AbsDatabase {

	public SqlserverDatabaseBean(String jdbcTemplate) {
		super(jdbcTemplate);
	}
	
//	public static final String FORMAT_STYLE = "120";

	public static final String PATTERN_DATE = "yyyy-MM-dd";
//	public static final String TYPE_DATE = "varchar(10)";

	public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
//	public static final String TYPE_DATETIME = "varchar(19)";

	public static final String PATTERN_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";
//	public static final String TYPE_TIMESTAMP = "varchar(23)";

	@Override
	public String getOpenQuote() {
		return "[";
	}

	@Override
	public String getCloseQuote() {
		return "]";
	}

	@Override
	public boolean hasIndex(String indexName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasTable(String tableName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasView(String viewName) {
		// TODO Auto-generated method stub
		return false;
	}

}

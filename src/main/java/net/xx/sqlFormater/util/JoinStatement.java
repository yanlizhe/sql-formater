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

package net.xx.sqlFormater.util;

public final class JoinStatement {
	
	private String key;
	
	private String sql;

	public JoinStatement(String key, String sql) {
		this.key = key;
		this.sql = sql;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}

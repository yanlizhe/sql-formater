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

public enum DbType {
	
	MYSQL("mysql"), 
	
	SQLSERVER("sqlserver"), 
	
	ORACLE("oracle"), 
	
	KINGBASE("kingbase");
	
	private String mValue;
	
	DbType(String value) {
		mValue = value;
	}

	public String getValue() {
		return mValue;
	}
	
	public static DbType getInstance(String value) {
		if(null != value) {
			switch(value.toLowerCase()) {
			case "sqlserver": return SQLSERVER;
			case "oracle": return ORACLE;
			case "kingbase": return KINGBASE;
			default: 
				return MYSQL;
			}
		}
		return null;
	}

}

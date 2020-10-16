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

package net.xx.sqlFormater.common;

import java.util.List;

public interface SqlFormaterRead extends SqlFormater {
	
	public String getSql(List<String> selection, String from, List<String> join, List<String> condition, List<String> groups, List<String> sort);
	
	public String getPagedSql(List<String> alias, List<String> selection, String from, List<String> join, List<String> condition, List<String> groups, List<String> sort);
	
	public Object[] getArgs(List<Object> args, int start, int size);

}

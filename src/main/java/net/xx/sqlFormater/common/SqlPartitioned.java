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

import java.util.Date;

public interface SqlPartitioned {
	
	/**
	 * 判断分区是否存在
	 * @param tableName 表名称
	 * @param partitionName 分区名称
	 * @return 如果存在返回<code>true</code>，如果不存在返回<code>false</code>
	 */
	public boolean hasPartition(String tableName, String partitionName);
	
	public boolean isPartitionInsertable(String tableName, long value);
	
	public boolean isPartitionInsertable(String tableName, Date value);
	
	public boolean addPartition(String tableName, String partitionMax, String partitionName, long value);
	
	public boolean addPartition(String tableName, String partitionMax, String partitionName, Date value);
	
	public boolean movePartition(String tableName, String partitionName, String tableSpace);
	
	public boolean dropPartition(String tableName, String partitionName);

}

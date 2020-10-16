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

package net.xx.sqlFormater.database;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import net.xx.sqlFormater.SqlBeanFactory;

public class GeneralPartitionedWrapper implements GeneralPartitioned, InitializingBean {
	
	private GeneralPartitioned mSource;
	
	public GeneralPartitionedWrapper(GeneralPartitioned source) {
		mSource = source;
	}
	
	public final GeneralPartitioned getSource() {
		return mSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(null == getSpringJdbc()) {
			setSpringJdbc(SqlBeanFactory.getAuto(JdbcTemplate.class));
		}
	}

	@Override
	public JdbcTemplate getSpringJdbc() {
		return getSource().getSpringJdbc();
	}

	@Override
	public void setSpringJdbc(JdbcTemplate springJdbc) {
		getSource().setSpringJdbc(springJdbc);
	}

	@Override
	public boolean hasPartition(String tableName, String partitionName) {
		return getSource().hasPartition(tableName, partitionName);
	}

	@Override
	public boolean isPartitionInsertable(String tableName, long value) {
		return getSource().isPartitionInsertable(tableName, value);
	}

	@Override
	public boolean isPartitionInsertable(String tableName, Date value) {
		return getSource().isPartitionInsertable(tableName, value);
	}

	@Override
	public boolean addPartition(String tableName, String partitionMax, String partitionName, long value) {
		return getSource().addPartition(tableName, partitionMax, partitionName, value);
	}

	@Override
	public boolean addPartition(String tableName, String partitionMax, String partitionName, Date value) {
		return getSource().addPartition(tableName, partitionMax, partitionName, value);
	}

	@Override
	public boolean movePartition(String tableName, String partitionName, String tableSpace) {
		return getSource().movePartition(tableName, partitionName, tableSpace);
	}

	@Override
	public boolean dropPartition(String tableName, String partitionName) {
		return getSource().dropPartition(tableName, partitionName);
	}

}

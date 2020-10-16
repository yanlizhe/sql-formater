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

package net.xx.sqlFormater.formater;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.database.GeneralDatabase;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class GeneralFormaterReadWrapper implements GeneralFormaterRead, InitializingBean {
	
	private GeneralFormaterRead mSource;
	
	public GeneralFormaterReadWrapper(String database) {
		this(InnerBeanFactory.createGeneralFormaterRead(database));
	}
	
	public GeneralFormaterReadWrapper(GeneralFormaterRead source) {
		mSource = source;
	}
	
	public final GeneralFormaterRead getSource() {
		return mSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(null == getGeneralDatabase()) {
			setGeneralDatabase(SqlBeanFactory.getAuto(GeneralDatabase.class));
		}
	}

	@Override
	public GeneralDatabase getGeneralDatabase() {
		return getSource().getGeneralDatabase();
	}

	@Override
	public void setGeneralDatabase(GeneralDatabase generalDatabase) {
		getSource().setGeneralDatabase(generalDatabase);
	}

	@Override
	public String getSql(List<String> selection, String from, List<String> join, List<String> condition,
			List<String> groups, List<String> sort) {
		return getSource().getSql(selection, from, join, condition, groups, sort);
	}

	@Override
	public String getPagedSql(List<String> alias, List<String> selection, String from, List<String> join,
			List<String> condition, List<String> groups, List<String> sort) {
		return getSource().getPagedSql(alias, selection, from, join, condition, groups, sort);
	}

	@Override
	public Object[] getArgs(List<Object> args) {
		return getSource().getArgs(args);
	}

	@Override
	public Object[] getArgs(List<Object> args, int start, int size) {
		return getSource().getArgs(args, start, size);
	}

}

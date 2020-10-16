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

public class GeneralFormaterInsertWrapper implements GeneralFormaterInsert, InitializingBean {
	
	private GeneralFormaterInsert mSource;
	
	public GeneralFormaterInsertWrapper(String database) {
		this(InnerBeanFactory.createGeneralFormaterInsert(database));
	}
	
	public GeneralFormaterInsertWrapper(GeneralFormaterInsert source) {
		mSource = source;
	}
	
	public final GeneralFormaterInsert getSource() {
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
	public String getSql(String table, List<String> columns, List<String> values) {
		return getSource().getSql(table, columns, values);
	}

	@Override
	public Object[] getArgs(List<Object> args) {
		return getSource().getArgs(args);
	}

}

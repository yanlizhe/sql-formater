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

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class GeneralDatabaseWrapper implements GeneralDatabase, InitializingBean {
	
	private GeneralDatabase mSource;
	
	public GeneralDatabaseWrapper() {
		this(InnerBeanFactory.createGeneralDatabase(null));
	}
	
	public GeneralDatabaseWrapper(String jdbcTemplate) {
		this(InnerBeanFactory.createGeneralDatabase(jdbcTemplate));
	}
	
	public GeneralDatabaseWrapper(GeneralDatabase source) {
		mSource = source;
	}
	
	public final GeneralDatabase getSource() {
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
	public String getOpenQuote() {
		return getSource().getOpenQuote();
	}

	@Override
	public String getCloseQuote() {
		return getSource().getCloseQuote();
	}

	@Override
	public boolean hasIndex(String indexName) {
		return getSource().hasIndex(indexName);
	}

	@Override
	public boolean hasTable(String tableName) {
		return getSource().hasTable(tableName);
	}

	@Override
	public boolean hasView(String viewName) {
		return getSource().hasView(viewName);
	}

}

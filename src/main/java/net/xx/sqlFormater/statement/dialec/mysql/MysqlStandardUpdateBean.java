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

package net.xx.sqlFormater.statement.dialec.mysql;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.mysql.MysqlDatabaseBean;
import net.xx.sqlFormater.filter.StandardFilterExecute;
import net.xx.sqlFormater.statement.dialec.AbsStandardUpdate;

public final class MysqlStandardUpdateBean extends AbsStandardUpdate {

	public MysqlStandardUpdateBean(StandardFilterExecute filter) {
		super(filter);
	}
	
	@Override
	public void pretreatment() {}
	
	private StandardFilterExecute mStandardFilterExecute;
	
	@Override
	public StandardFilterExecute getStandardFilterExecute() {
		return mStandardFilterExecute;
	}
	
	@Override
	public void setStandardFilterExecute(StandardFilterExecute standardFilterExecute) {
		mStandardFilterExecute = standardFilterExecute;
	}

	public MysqlStandardUpdateBean(String filter, String formater) {
		super(filter, formater);
	}

	@Override
	public void setDateValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(MysqlDatabaseBean.PATTERN_DATE);
			pushDateValue(column, formater.format(value), MysqlDatabaseBean.FORMAT_DATE);
		}
	}

	@Override
	public void setDateTimeValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(MysqlDatabaseBean.PATTERN_DATETIME);
			pushDateValue(column, formater.format(value), MysqlDatabaseBean.FORMAT_DATETIME);
		}
	}

	@Override
	public void setDateTimeValue(String column) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" = sysdate()");
		pushRawSet(sql.toString());
	}

	@Override
	public void setTimestampValue(String column) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" = sysdate()");
		pushRawSet(sql.toString());
	}
	
	private void pushDateValue(String column, String value, String former) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" = str_to_date(?, ?)");
		pushRawSet(sql.toString());
		pushRawValue(value);
		pushRawValue(former);
	}

}

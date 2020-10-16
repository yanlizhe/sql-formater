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

package net.xx.sqlFormater.statement.dialec;

import org.springframework.util.StringUtils;

import net.xx.sqlFormater.statement.StandardStatementInsert;

public abstract class AbsStandardInsert extends AbsGeneralInsert implements StandardStatementInsert {

	protected AbsStandardInsert(String formater) {
		super(formater);
	}

	@Override
	public void setTable(String table) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		setRawFrom(sql.toString());
	}

	@Override
	public void setNullValue(String column) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		pushRawColumn(sql.toString());
		pushRawValue("null");
	}

	@Override
	public void setValue(String column, Object value) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		pushRawColumn(sql.toString());
		pushRawValue("?");
		pushRawArg(value);
	}

	@Override
	public void setByteValue(String column, Byte value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setShortValue(String column, Short value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setIntegerValue(String column, Integer value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setLongValue(String column, Long value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setFloatValue(String column, Float value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setDoubleValue(String column, Double value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setStringValue(String column, String value) {
		if (StringUtils.isEmpty(value)) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

}

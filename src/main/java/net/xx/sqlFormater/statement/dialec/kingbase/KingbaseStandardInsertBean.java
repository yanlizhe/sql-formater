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

package net.xx.sqlFormater.statement.dialec.kingbase;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.kingbase.KingbaseDatabaseBean;
import net.xx.sqlFormater.statement.dialec.AbsStandardInsert;

public final class KingbaseStandardInsertBean extends AbsStandardInsert {

	public KingbaseStandardInsertBean(String formater) {
		super(formater);
	}

	@Override
	public void pretreatment() {}

	@Override
	public void setDateValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
			setValue(column, formater.format(value));
		}
	}

	@Override
	public void setDateTimeValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
			setValue(column, formater.format(value));
		}
	}

	@Override
	public void setDateTimeValue(String column) {
		pushRawColumn(quoted(column));
		pushRawValue("SYSTIMESTAMP");
	}

	@Override
	public void setTimestampValue(String column) {
		pushRawColumn(quoted(column));
		pushRawValue("SYSTIMESTAMP");
	}

}

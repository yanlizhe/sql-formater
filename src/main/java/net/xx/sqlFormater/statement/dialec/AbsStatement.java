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

import net.xx.sqlFormater.statement.BaseStatement;

abstract class AbsStatement implements BaseStatement {
	
	private String mRawFrom;

	@Override
	public final String getOpenQuote() {
		return getGeneralFormater().getOpenQuote();
	}

	@Override
	public final String getCloseQuote() {
		return getGeneralFormater().getCloseQuote();
	}

	@Override
	public final String quoted(String text) {
		return getGeneralFormater().quoted(text);
	}

	@Override
	public final String quoted(String table, String column) {
		return getGeneralFormater().quoted(table, column);
	}

	public void setBaseFrom(String sql) {
		mRawFrom = sql;
	}
	
	public String getBaseFrom() {
		return mRawFrom;
	}

}

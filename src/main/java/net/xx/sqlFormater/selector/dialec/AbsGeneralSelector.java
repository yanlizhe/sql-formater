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

package net.xx.sqlFormater.selector.dialec;

import net.xx.sqlFormater.selector.GeneralSelector;
import net.xx.sqlFormater.statement.BaseStatementRead;
import net.xx.sqlFormater.statement.GeneralStatementRead;
import net.xx.sqlFormater.statement.GeneralStatementReadWrapper;
import net.xx.sqlFormater.util.JoinStatement;

abstract class AbsGeneralSelector extends AbsBaseSelector implements GeneralSelector {

	@Override
	public final BaseStatementRead getBaseStatementRead() {
		GeneralStatementRead statement = getGeneralStatementRead();
		if (statement instanceof GeneralStatementReadWrapper) {
			statement = ((GeneralStatementReadWrapper) statement).getSource();
		}
		return (BaseStatementRead) statement;
	}
	
	@Override
	public final void setBaseStatementRead(BaseStatementRead baseStatementRead) {
		setGeneralStatementRead((GeneralStatementRead) baseStatementRead);
	}
	
	

	@Override
	public void pushRawAlias(String sql) {
		getBaseAlias(true).add(sql);
	}

	@Override
	public void pushRawSelection(String sql) {
		getBaseSelection(true).add(sql);
	}

	@Override
	public void setRawFrom(String key, String sql) {
		getGeneralStatementRead().setRawFrom(key, sql);
	}

	@Override
	public void unshiftRawJoin(String key, String sql) {
		getGeneralStatementRead().unshiftRawJoin(key, sql);
	}

	@Override
	public void pushRawJoin(String key, String sql) {
		getGeneralStatementRead().pushRawJoin(key, sql);
	}

	@Override
	public JoinStatement getRawJoin(String key) {
		return getGeneralStatementRead().getRawJoin(key);
	}

	@Override
	public void refreshRawJoin(String key, String sql) {
		getGeneralStatementRead().refreshRawJoin(key, sql);
	}

	@Override
	public void pushRawCondition(String sql) {
		getGeneralStatementRead().pushRawCondition(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getGeneralStatementRead().pushRawArg(arg);
	}

	@Override
	public void mergeRawArg(Object[] args) {
		getGeneralStatementRead().mergeRawArg(args);
	}

	@Override
	public void unshiftRawGroup(String sql) {
		getBaseGroup(true).add(0, sql);
	}

	@Override
	public void pushRawGroup(String sql) {
		getBaseGroup(true).add(sql);
	}

	@Override
	public void unshiftRawSort(String sql) {
		getBaseSort(true).add(0, sql);
	}

	@Override
	public void pushRawSort(String sql) {
		getBaseSort(true).add(sql);
	}

}

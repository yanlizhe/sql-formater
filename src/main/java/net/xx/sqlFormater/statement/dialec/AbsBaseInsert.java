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

import java.util.LinkedList;
import java.util.List;

import net.xx.sqlFormater.formater.GeneralFormater;
import net.xx.sqlFormater.formater.GeneralFormaterInsert;
import net.xx.sqlFormater.formater.GeneralFormaterInsertWrapper;
import net.xx.sqlFormater.statement.BaseStatementInsert;

abstract class AbsBaseInsert extends AbsStatement implements BaseStatementInsert {

	@Override
	public final GeneralFormater getGeneralFormater() {
		GeneralFormaterInsert formater = getGeneralFormaterInsert();
		if (null != formater && formater instanceof GeneralFormaterInsertWrapper) {
			formater = ((GeneralFormaterInsertWrapper) formater).getSource();
		}
		return (GeneralFormater) formater;
	}
	
	@Override
	public final void setGeneralFormater(GeneralFormater generalFormater) {
		setGeneralFormaterInsert((GeneralFormaterInsert) generalFormater);
	}
	
	

	@Override
	public final String getSql() {
		return getGeneralFormaterInsert().getSql(getBaseFrom(), getBaseColumns(false), getBaseValues(false));
	}

	@Override
	public final Object[] getArgs() {
		return getGeneralFormaterInsert().getArgs(getBaseArgs(false));
	}
	
	
	
	@Override
	public final int execute() {
		return getGeneralFormater().getGeneralDatabase().getSpringJdbc().update(getSql(), getArgs());
	}



	private LinkedList<String> mBaseColumns;
	private LinkedList<String> mBaseValues;
	private LinkedList<Object> mBaseArgs;

	public List<String> getBaseColumns(boolean generated) {
		if (null == mBaseColumns && generated) {
			mBaseColumns = new LinkedList<String>();
		}
		return mBaseColumns;
	}

	public List<String> getBaseValues(boolean generated) {
		if (null == mBaseValues && generated) {
			mBaseValues = new LinkedList<String>();
		}
		return mBaseValues;
	}

	public List<Object> getBaseArgs(boolean generated) {
		if (null == mBaseArgs && generated) {
			mBaseArgs = new LinkedList<Object>();
		}
		return mBaseArgs;
	}

}

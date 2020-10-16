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

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.formater.GeneralFormaterInsert;
import net.xx.sqlFormater.statement.GeneralStatementInsert;

abstract class AbsGeneralInsert extends AbsBaseInsert implements GeneralStatementInsert {

	protected AbsGeneralInsert(String formater) {
		if(SqlBeanFactory.hasName(formater)) {
			setGeneralFormaterInsert(SqlBeanFactory.getBean(formater, GeneralFormaterInsert.class));
		}
	}
	
	private GeneralFormaterInsert mGeneralFormaterInsert;

	@Override
	public GeneralFormaterInsert getGeneralFormaterInsert() {
		return mGeneralFormaterInsert;
	}

	@Override
	public void setGeneralFormaterInsert(GeneralFormaterInsert generalFormaterInsert) {
		mGeneralFormaterInsert = generalFormaterInsert;
	}
	
	@Override
	public void setRawFrom(String sql) {
		setBaseFrom(sql);
	}

	@Override
	public void pushRawColumn(String sql) {
		getBaseColumns(true).add(sql);
	}

	@Override
	public void pushRawValue(String sql) {
		getBaseValues(true).add(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getBaseArgs(true).add(arg);
	}

}

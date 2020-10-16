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
import net.xx.sqlFormater.filter.BaseFilterExecute;
import net.xx.sqlFormater.filter.GeneralFilterExecute;
import net.xx.sqlFormater.filter.GeneralFilterExecuteWrapper;
import net.xx.sqlFormater.formater.GeneralFormaterDelete;
import net.xx.sqlFormater.statement.GeneralStatementDelete;

abstract class AbsGeneralDelete extends AbsBaseDelete implements GeneralStatementDelete {
	
	protected AbsGeneralDelete(GeneralFilterExecute filter) {
		if (null != filter) {
			setGeneralFilterExecute(filter);
		}
	}
	
	protected AbsGeneralDelete(String filter, String formater) {
		if(SqlBeanFactory.hasName(filter)) {
			setGeneralFilterExecute(SqlBeanFactory.getBean(filter, GeneralFilterExecute.class));
		}
		if(SqlBeanFactory.hasName(formater)) {
			setGeneralFormaterDelete(SqlBeanFactory.getBean(formater, GeneralFormaterDelete.class));
		}
	}
	
	private GeneralFormaterDelete mGeneralFormaterDelete;

	@Override
	public GeneralFormaterDelete getGeneralFormaterDelete() {
		return mGeneralFormaterDelete;
	}

	@Override
	public void setGeneralFormaterDelete(GeneralFormaterDelete generalFormaterDelete) {
		mGeneralFormaterDelete = generalFormaterDelete;
	}

	@Override
	public final BaseFilterExecute getBaseFilterExecute() {
		GeneralFilterExecute filter = getGeneralFilterExecute();
		if (filter instanceof GeneralFilterExecuteWrapper) {
			filter = ((GeneralFilterExecuteWrapper) filter).getSource();
		}
		return (BaseFilterExecute) filter;
	}
	
	@Override
	public final void setBaseFilterExecute(BaseFilterExecute baseFilterExecute) {
		setGeneralFilterExecute((GeneralFilterExecute) baseFilterExecute);
	}
	
	
	
	@Override
	public void setRawFrom(String sql) {
		setBaseFrom(sql);
	}

	@Override
	public void pushRawCondition(String sql) {
		getGeneralFilterExecute().pushRawCondition(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getGeneralFilterExecute().pushRawArg(arg);
	}

	@Override
	public void mergeRawArg(Object[] args) {
		getGeneralFilterExecute().mergeRawArg(args);
	}

}

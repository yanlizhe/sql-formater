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

import java.util.List;

import net.xx.sqlFormater.formater.GeneralFormater;
import net.xx.sqlFormater.formater.GeneralFormaterDelete;
import net.xx.sqlFormater.formater.GeneralFormaterDeleteWrapper;
import net.xx.sqlFormater.statement.BaseStatementDelete;

abstract class AbsBaseDelete extends AbsStatement implements BaseStatementDelete {
	
	@Override
	public final GeneralFormater getGeneralFormater() {
		GeneralFormaterDelete formater = getGeneralFormaterDelete();
		if (null != formater && formater instanceof GeneralFormaterDeleteWrapper) {
			formater = ((GeneralFormaterDeleteWrapper) formater).getSource();
		}
		return (GeneralFormater) formater;
	}
	
	@Override
	public final void setGeneralFormater(GeneralFormater generalFormater) {
		setGeneralFormaterDelete((GeneralFormaterDelete) generalFormater);
	}
	
	

	@Override
	public final String getSql() {
		return getGeneralFormaterDelete().getSql(getBaseFrom(), 
				getBaseFilterExecute().getBaseCondition(false));
	}

	@Override
	public final Object[] getArgs() {
		return getGeneralFormaterDelete().getArgs(getBaseFilterExecute().getBaseArgs(false));
	}
	
	
	
	@Override
	public final int execute() {
		return getGeneralFormater().getGeneralDatabase().getSpringJdbc().update(getSql(), getArgs());
	}
	
	

	@Override
	public List<String> getBaseCondition(boolean generated) {
		return getBaseFilterExecute().getBaseCondition(generated);
	}

	@Override
	public List<Object> getBaseArgs(boolean generated) {
		return getBaseFilterExecute().getBaseArgs(generated);
	}

}

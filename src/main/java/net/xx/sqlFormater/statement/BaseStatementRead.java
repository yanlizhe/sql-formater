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

package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.common.SqlStatementReadable;
import net.xx.sqlFormater.filter.BaseFilterReadable;
import net.xx.sqlFormater.filter.InnerBaseCondition;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.selector.BaseSelector;
import net.xx.sqlFormater.selector.InnerBaseSelector;

public interface BaseStatementRead extends SqlStatementReadable, BaseStatement, BaseJoin, InnerBaseSelector, InnerBaseCondition {
	
	public GeneralFormaterRead getGeneralFormaterRead();
	
	public void setGeneralFormaterRead(GeneralFormaterRead generalFormaterRead);
	
	public BaseSelector getBaseSelector();
	
	public void setBaseSelector(BaseSelector baseSelector);
	
	public BaseFilterReadable getBaseFilterReadable();
	
	public void setBaseFilterReadable(BaseFilterReadable baseFilterReadable);

}

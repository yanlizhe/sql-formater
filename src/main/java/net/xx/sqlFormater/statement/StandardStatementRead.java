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

import net.xx.sqlFormater.SqlStandardRead;
import net.xx.sqlFormater.filter.InnerGeneralCondition;
import net.xx.sqlFormater.filter.InnerStandardConditionReadable;
import net.xx.sqlFormater.filter.StandardFilterReadable;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.selector.InnerGeneralSelector;
import net.xx.sqlFormater.selector.InnerStandardSelector;
import net.xx.sqlFormater.selector.StandardSelector;

public interface StandardStatementRead extends StandardStatement, SqlStandardRead, InnerStandardMain, 
		InnerStandardSelector, InnerStandardJoin, InnerStandardConditionReadable, InnerGeneralFormater, 
		InnerGeneralMainReadable, InnerGeneralJoin, InnerGeneralSelector, InnerGeneralCondition {
	
	public StandardSelector getStandardSelector();
	
	public void setStandardSelector(StandardSelector standardSelector);
	
	public StandardFilterReadable getStandardFilterReadable();
	
	public void setStandardFilterReadable(StandardFilterReadable standardFilterReadable);
	
	public GeneralFormaterRead getGeneralFormaterRead();
	
	public void setGeneralFormaterRead(GeneralFormaterRead generalFormaterRead);

}

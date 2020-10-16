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

import net.xx.sqlFormater.filter.GeneralFilterReadable;
import net.xx.sqlFormater.selector.GeneralSelector;

public final class GeneralReadBean extends AbsGeneralRead {
	
	public GeneralReadBean(GeneralSelector selector, GeneralFilterReadable filter) {
		super(selector, filter);
	}

	public GeneralReadBean(String selector, String filter, String formater) {
		super(selector, filter, formater);
	}
	
	private GeneralSelector mGeneralSelector;
	
	@Override
	public GeneralSelector getGeneralSelector() {
		return mGeneralSelector;
	}
	
	@Override
	public void setGeneralSelector(GeneralSelector generalSelector) {
		mGeneralSelector = generalSelector;
	}
	
	private GeneralFilterReadable mGeneralFilterReadable;
	
	@Override
	public GeneralFilterReadable getGeneralFilterReadable() {
		return mGeneralFilterReadable;
	}
	
	@Override
	public void setGeneralFilterReadable(GeneralFilterReadable generalFilterReadable) {
		mGeneralFilterReadable = generalFilterReadable;
	}
	
	@Override
	public void pretreatment() {}

}

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

import java.util.LinkedList;
import java.util.List;

import net.xx.sqlFormater.selector.BaseSelector;
import net.xx.sqlFormater.util.JoinStatement;

abstract class AbsBaseSelector implements BaseSelector {

	@Override
	public final String getOpenQuote() {
		return getBaseStatementRead().getOpenQuote();
	}

	@Override
	public final String getCloseQuote() {
		return getBaseStatementRead().getCloseQuote();
	}

	@Override
	public final String quoted(String text) {
		return getBaseStatementRead().quoted(text);
	}

	@Override
	public final String quoted(String table, String column) {
		return getBaseStatementRead().quoted(table, column);
	}
	
	
	
	private LinkedList<String> mBaseAlias;
	private LinkedList<String> mBaseSelection;
	private LinkedList<String> mBaseGroup;
	private LinkedList<String> mBaseSort;

	@Override
	public List<String> getBaseAlias(boolean generated) {
		if (null == mBaseAlias && generated) {
			mBaseAlias = new LinkedList<String>();
		}
		return mBaseAlias;
	}

	@Override
	public List<String> getBaseSelection(boolean generated) {
		if (null == mBaseSelection && generated) {
			mBaseSelection = new LinkedList<String>();
		}
		return mBaseSelection;
	}

	@Override
	public void setBaseFrom(String sql) {
		getBaseStatementRead().setBaseFrom(sql);
	}

	@Override
	public String getBaseFrom() {
		return getBaseStatementRead().getBaseFrom();
	}

	@Override
	public List<JoinStatement> getBaseJoin(boolean generated) {
		return getBaseStatementRead().getBaseJoin(generated);
	}

	@Override
	public List<String> getBaseCondition(boolean generated) {
		return getBaseStatementRead().getBaseCondition(generated);
	}

	@Override
	public List<Object> getBaseArgs(boolean generated) {
		return getBaseStatementRead().getBaseArgs(generated);
	}

	@Override
	public List<String> getBaseGroup(boolean generated) {
		if (null == mBaseGroup && generated) {
			mBaseGroup = new LinkedList<String>();
		}
		return mBaseGroup;
	}

	@Override
	public List<String> getBaseSort(boolean generated) {
		if (null == mBaseSort && generated) {
			mBaseSort = new LinkedList<String>();
		}
		return mBaseSort;
	}

}

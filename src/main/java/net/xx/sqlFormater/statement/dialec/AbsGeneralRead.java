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

import java.util.Iterator;
import java.util.List;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.filter.BaseFilterReadable;
import net.xx.sqlFormater.filter.GeneralFilterReadable;
import net.xx.sqlFormater.filter.GeneralFilterReadableWrapper;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.selector.BaseSelector;
import net.xx.sqlFormater.selector.GeneralSelector;
import net.xx.sqlFormater.selector.GeneralSelectorWrapper;
import net.xx.sqlFormater.statement.GeneralStatementRead;
import net.xx.sqlFormater.util.JoinStatement;

abstract class AbsGeneralRead extends AbsBaseRead implements GeneralStatementRead {
	
	protected AbsGeneralRead(GeneralSelector selector, GeneralFilterReadable filter) {
		if (null != selector) {
			setGeneralSelector(selector);
		}
		if (null != filter) {
			setGeneralFilterReadable(filter);
		}
	}
	
	protected AbsGeneralRead(String selector, String filter, String formater) {
		if(SqlBeanFactory.hasName(selector)) {
			setGeneralSelector(SqlBeanFactory.getBean(selector, GeneralSelector.class));
		}
		if(SqlBeanFactory.hasName(filter)) {
			setGeneralFilterReadable(SqlBeanFactory.getBean(filter, GeneralFilterReadable.class));
		}
		if(SqlBeanFactory.hasName(formater)) {
			setGeneralFormaterRead(SqlBeanFactory.getBean(formater, GeneralFormaterRead.class));
		}
	}

	@Override
	public final BaseSelector getBaseSelector() {
		GeneralSelector selector = getGeneralSelector();
		if (null != selector && selector instanceof GeneralSelectorWrapper) {
			selector = ((GeneralSelectorWrapper) selector).getSource();
		}
		return (BaseSelector) selector;
	}
	
	@Override
	public final void setBaseSelector(BaseSelector baseSelector) {
		setGeneralSelector((GeneralSelector) baseSelector);
	}

	@Override
	public final BaseFilterReadable getBaseFilterReadable() {
		GeneralFilterReadable filter = getGeneralFilterReadable();
		if (null != filter && filter instanceof GeneralFilterReadableWrapper) {
			filter = ((GeneralFilterReadableWrapper) filter).getSource();
		}
		return (BaseFilterReadable) filter;
	}
	
	@Override
	public final void setBaseFilterReadable(BaseFilterReadable baseFilterReadable) {
		setGeneralFilterReadable((GeneralFilterReadable) baseFilterReadable);
	}
	

	
	private GeneralFormaterRead mGeneralFormaterRead;

	@Override
	public GeneralFormaterRead getGeneralFormaterRead() {
		return mGeneralFormaterRead;
	}

	@Override
	public void setGeneralFormaterRead(GeneralFormaterRead generalFormaterRead) {
		mGeneralFormaterRead = generalFormaterRead;
	}
	
	

	@Override
	public void pushRawAlias(String sql) {
		getGeneralSelector().pushRawAlias(sql);
	}

	@Override
	public void pushRawSelection(String sql) {
		getGeneralSelector().pushRawSelection(sql);
	}

	@Override
	public void setRawFrom(String key, String sql) {
		setBaseTableKey(key);
		setBaseFrom(sql);
	}

	@Override
	public void unshiftRawJoin(String key, String sql) {
		getBaseJoin(true).add(0, new JoinStatement(key, sql));
	}

	@Override
	public void pushRawJoin(String key, String sql) {
		getBaseJoin(true).add(new JoinStatement(key, sql));
	}

	@Override
	public JoinStatement getRawJoin(String key) {
		final List<JoinStatement> list = getBaseJoin(false);
		if (null != list) {
			final Iterator<JoinStatement> iterator = list.iterator();
			while(iterator.hasNext()) {
				JoinStatement item = iterator.next();
				if(item.getKey().equals(key)) {
					return item;
				}
			}
		}
		return null;
	}

	@Override
	public void refreshRawJoin(String key, String sql) {
		JoinStatement statement = getRawJoin(key);
		if (null == statement) {
			getBaseJoin(true).add(new JoinStatement(key, sql));
		} else {
			statement.setSql(sql);
		}
	}

	@Override
	public void pushRawCondition(String sql) {
		getGeneralFilterReadable().pushRawCondition(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getGeneralFilterReadable().pushRawArg(arg);
	}

	@Override
	public void mergeRawArg(Object[] args) {
		getGeneralFilterReadable().mergeRawArg(args);
	}

	@Override
	public void unshiftRawGroup(String sql) {
		getGeneralSelector().unshiftRawGroup(sql);
	}

	@Override
	public void pushRawGroup(String sql) {
		getGeneralSelector().pushRawGroup(sql);
	}

	@Override
	public void unshiftRawSort(String sql) {
		getGeneralSelector().unshiftRawSort(sql);
	}

	@Override
	public void pushRawSort(String sql) {
		getGeneralSelector().pushRawSort(sql);
	}

}

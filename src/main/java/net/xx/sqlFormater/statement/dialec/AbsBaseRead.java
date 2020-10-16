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

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import net.xx.sqlFormater.formater.GeneralFormater;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.formater.GeneralFormaterReadWrapper;
import net.xx.sqlFormater.statement.BaseStatementRead;
import net.xx.sqlFormater.util.JoinStatement;

abstract class AbsBaseRead extends AbsStatement 
		implements BaseStatementRead {

	@Override
	public final GeneralFormater getGeneralFormater() {
		GeneralFormaterRead formater = getGeneralFormaterRead();
		if (null != formater && formater instanceof GeneralFormaterReadWrapper) {
			formater = ((GeneralFormaterReadWrapper) formater).getSource();
		}
		return (GeneralFormater) formater;
	}

	@Override
	public final void setGeneralFormater(GeneralFormater generalFormater) {
		setGeneralFormaterRead((GeneralFormaterRead) generalFormater);
	}
	


	@Override
	public final String getSql() {
		return getGeneralFormaterRead().getSql(
				getBaseSelection(false), 
				getBaseFrom(), 
				getFiltedJoin(), 
				getBaseCondition(false), 
				getBaseGroup(false), 
				getBaseSort(false));
	}

	@Override
	public final Object[] getArgs() {
		return getGeneralFormaterRead().getArgs(getBaseArgs(false));
	}

	@Override
	public final String getPagedSql() {
		return getGeneralFormaterRead().getPagedSql(
				getBaseAlias(false), 
				getBaseSelection(false), 
				getBaseFrom(), 
				getFiltedJoin(), 
				getBaseCondition(false), 
				getBaseGroup(false), 
				getBaseSort(false));
	}

	@Override
	public final Object[] getArgs(int start, int limit) {
		return getGeneralFormaterRead().getArgs(getBaseArgs(false), start, limit);
	}
	
	
	
	private JdbcTemplate getSpringJdbc() {
		return getGeneralFormater().getGeneralDatabase().getSpringJdbc();
	}

	@Override
	public final Byte queryByte() {
		return getSpringJdbc().queryForObject(getSql(), getArgs(), Byte.class);
	}

	@Override
	public final Short queryShort() {
		return getSpringJdbc().queryForObject(getSql(), getArgs(), Short.class);
	}

	@Override
	public final Integer queryInteger() {
		return getSpringJdbc().queryForObject(getSql(), getArgs(), Integer.class);
	}

	@Override
	public final Long queryLong() {
		return getSpringJdbc().queryForObject(getSql(), getArgs(), Long.class);
	}

	@Override
	public final Float queryFloat() {
		return getSpringJdbc().queryForObject(getSql(), getArgs(), Float.class);
	}

	@Override
	public final Double queryDouble() {
		return getSpringJdbc().queryForObject(getSql(), getArgs(), Double.class);
	}

	@Override
	public final String queryString() {
		return getSpringJdbc().queryForObject(getSql(), getArgs(), String.class);
	}

	@Override
	public final Date queryDate() {
		return getSpringJdbc().queryForObject(getSql(), getArgs(), Date.class);
	}

	@Override
	public final <T> T queryObject(RowMapper<T> mapper) {
		return getSpringJdbc().queryForObject(getSql(), getArgs(), mapper);
	}

	@Override
	public final Byte queryFirstByte() {
		return getSpringJdbc().queryForObject(getPagedSql(), getArgs(0, 1), Byte.class);
	}

	@Override
	public final Short queryFirstShort() {
		return getSpringJdbc().queryForObject(getPagedSql(), getArgs(0, 1), Short.class);
	}

	@Override
	public final Integer queryFirstInteger() {
		return getSpringJdbc().queryForObject(getPagedSql(), getArgs(0, 1), Integer.class);
	}

	@Override
	public final Long queryFirstLong() {
		return getSpringJdbc().queryForObject(getPagedSql(), getArgs(0, 1), Long.class);
	}

	@Override
	public final Float queryFirstFloat() {
		return getSpringJdbc().queryForObject(getPagedSql(), getArgs(0, 1), Float.class);
	}

	@Override
	public final Double queryFirstDouble() {
		return getSpringJdbc().queryForObject(getPagedSql(), getArgs(0, 1), Double.class);
	}

	@Override
	public final String queryFirstString() {
		return getSpringJdbc().queryForObject(getPagedSql(), getArgs(0, 1), String.class);
	}

	@Override
	public final Date queryFirstDate() {
		return getSpringJdbc().queryForObject(getPagedSql(), getArgs(0, 1), Date.class);
	}

	@Override
	public final <T> T queryFirstObject(RowMapper<T> mapper) {
		return getSpringJdbc().queryForObject(getPagedSql(), getArgs(0, 1), mapper);
	}

	@Override
	public final List<Byte> queryByteList() {
		return getSpringJdbc().queryForList(getSql(), getArgs(), Byte.class);
	}

	@Override
	public final List<Short> queryShortList() {
		return getSpringJdbc().queryForList(getSql(), getArgs(), Short.class);
	}

	@Override
	public final List<Integer> queryIntegerList() {
		return getSpringJdbc().queryForList(getSql(), getArgs(), Integer.class);
	}

	@Override
	public final List<Long> queryLongList() {
		return getSpringJdbc().queryForList(getSql(), getArgs(), Long.class);
	}

	@Override
	public final List<Float> queryFloatList() {
		return getSpringJdbc().queryForList(getSql(), getArgs(), Float.class);
	}

	@Override
	public final List<Double> queryDoubleList() {
		return getSpringJdbc().queryForList(getSql(), getArgs(), Double.class);
	}

	@Override
	public final List<String> queryStringList() {
		return getSpringJdbc().queryForList(getSql(), getArgs(), String.class);
	}

	@Override
	public final List<Date> queryDateList() {
		return getSpringJdbc().queryForList(getSql(), getArgs(), Date.class);
	}

	@Override
	public final <T> List<T> queryObjectList(RowMapper<T> mapper) {
		return getSpringJdbc().query(getSql(), getArgs(), mapper);
	}

	@Override
	public final List<Byte> queryByteList(int start, int limit) {
		return getSpringJdbc().queryForList(getPagedSql(), getArgs(start, limit), Byte.class);
	}

	@Override
	public final List<Short> queryShortList(int start, int limit) {
		return getSpringJdbc().queryForList(getPagedSql(), getArgs(start, limit), Short.class);
	}

	@Override
	public final List<Integer> queryIntegerList(int start, int limit) {
		return getSpringJdbc().queryForList(getPagedSql(), getArgs(start, limit), Integer.class);
	}

	@Override
	public final List<Long> queryLongList(int start, int limit) {
		return getSpringJdbc().queryForList(getPagedSql(), getArgs(start, limit), Long.class);
	}

	@Override
	public final List<Float> queryFloatList(int start, int limit) {
		return getSpringJdbc().queryForList(getPagedSql(), getArgs(start, limit), Float.class);
	}

	@Override
	public final List<Double> queryDoubleList(int start, int limit) {
		return getSpringJdbc().queryForList(getPagedSql(), getArgs(start, limit), Double.class);
	}

	@Override
	public final List<String> queryStringList(int start, int limit) {
		return getSpringJdbc().queryForList(getPagedSql(), getArgs(start, limit), String.class);
	}

	@Override
	public final List<Date> queryDateList(int start, int limit) {
		return getSpringJdbc().queryForList(getPagedSql(), getArgs(start, limit), Date.class);
	}

	@Override
	public final <T> List<T> queryObjectList(RowMapper<T> mapper, int start, int limit) {
		return getSpringJdbc().query(getPagedSql(), getArgs(start, limit), mapper);
	}



	private String mTableKey;
	private LinkedList<JoinStatement> mBaseJoin;

	@Override
	public List<String> getBaseAlias(boolean generated) {
		return getBaseSelector().getBaseAlias(generated);
	}

	@Override
	public List<String> getBaseSelection(boolean generated) {
		return getBaseSelector().getBaseSelection(generated);
	}

	@Override
	public List<JoinStatement> getBaseJoin(boolean generated) {
		if (null == mBaseJoin && generated) {
			mBaseJoin = new LinkedList<JoinStatement>();
		}
		return mBaseJoin;
	}

	@Override
	public List<String> getBaseCondition(boolean generated) {
		return getBaseFilterReadable().getBaseCondition(generated);
	}

	@Override
	public List<Object> getBaseArgs(boolean generated) {
		return getBaseFilterReadable().getBaseArgs(generated);
	}

	@Override
	public List<String> getBaseGroup(boolean generated) {
		return getBaseSelector().getBaseGroup(generated);
	}

	@Override
	public List<String> getBaseSort(boolean generated) {
		return getBaseSelector().getBaseSort(generated);
	}

	protected void setBaseTableKey(String key) {
		mTableKey = key;
	}
	
	protected String getBaseTableKey() {
		return mTableKey;
	}

	protected List<String> getFiltedJoin() {
		LinkedList<String> result = new LinkedList<String>();
		final HashSet<String> keys = new HashSet<String>();
		if(!StringUtils.isEmpty(mTableKey)) {
			keys.add(mTableKey);
		}
		if (null != mBaseJoin) {
			for (int i = 0, size = mBaseJoin.size(); i < size; i++) {
				final JoinStatement item = mBaseJoin.get(i);
				if(!keys.contains(item.getKey())) {
					result.add(item.getSql());
					keys.add(item.getKey());
				}
			}
		}
		return result;
	}

}

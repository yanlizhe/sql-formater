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

package net.xx.sqlFormater.filter;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.CommonBeanFactory;
import net.xx.sqlFormater.enumerate.ConditionType;
import net.xx.sqlFormater.enumerate.JoinType;
import net.xx.sqlFormater.statement.StandardStatement;
import net.xx.sqlFormater.statement.StandardStatementRead;
import net.xx.sqlFormater.util.InnerBeanFactory;
import net.xx.sqlFormater.util.JoinStatement;

public class StandardFilterReadableWrapper implements StandardFilterReadable, InitializingBean {

	/**
	 * 根据名称获取某类型的spring bean
	 * @param name bean名称
	 * @param clazz 数据类型
	 * @return spring bean
	 */
	protected static <T> T getBean(String name, Class<T> clazz) {
        return CommonBeanFactory.getBean(name, clazz);
    }
	
	private StandardFilterReadable mSource;
	
	public StandardFilterReadableWrapper() {
		this(InnerBeanFactory.createStandardFilterReadable());
	}
	
	public StandardFilterReadableWrapper(StandardFilterReadable source) {
		mSource = source;
	}
	
	public final StandardFilterReadable getSource() {
		return mSource;
	}
	
	public void wiring() {}

	@Override
	public final void afterPropertiesSet() throws Exception {
		wiring();
	}

	@Override
	public StandardStatement getStandardStatement() {
		return getSource().getStandardStatement();
	}

	@Override
	public void setStandardStatement(StandardStatement standardStatement) {
		getSource().setStandardStatement(standardStatement);
	}

	@Override
	public final StandardStatementRead getStandardStatementRead() {
		return getSource().getStandardStatementRead();
	}

	@Override
	public final void setStandardStatementRead(StandardStatementRead standardStatementRead) {
		getSource().setStandardStatementRead(standardStatementRead);
	}

	@Override
	public void pretreatment() {
		getSource().pretreatment();
	}

	@Override
	public void setTable(String table) {
		getSource().setTable(table);
	}

	@Override
	public void pushSelection(String table, String column, String alias) {
		getSource().pushSelection(table, column, alias);
	}

	@Override
	public void pushOperationSelection(String operation, String alias) {
		getSource().pushOperationSelection(operation, alias);
	}

	@Override
	public void unshiftGroup(String table, String column) {
		getSource().unshiftGroup(table, column);
	}

	@Override
	public void pushGroup(String table, String column) {
		getSource().pushGroup(table, column);
	}

	@Override
	public void unshiftSort(String table, String column) {
		getSource().unshiftSort(table, column);
	}

	@Override
	public void unshiftSort(String table, String column, boolean isAsc) {
		getSource().unshiftSort(table, column, isAsc);
	}

	@Override
	public void pushSort(String table, String column) {
		getSource().pushSort(table, column);
	}

	@Override
	public void pushSort(String table, String column, boolean isAsc) {
		getSource().pushSort(table, column, isAsc);
	}

	@Override
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn) {
		getSource().unshiftJoin(joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		getSource().unshiftJoin(joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		getSource().unshiftJoin(joinType, joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn,
			String alias) {
		getSource().unshiftJoin(joinType, joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		getSource().unshiftJoin(joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns,
			String alias) {
		getSource().unshiftJoin(joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable,
			String[] refColumns) {
		getSource().unshiftJoin(joinType, joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable,
			String[] refColumns, String alias) {
		getSource().unshiftJoin(joinType, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn) {
		getSource().pushJoin(joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		getSource().pushJoin(joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		getSource().pushJoin(joinType, joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn,
			String alias) {
		getSource().pushJoin(joinType, joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		getSource().pushJoin(joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable,
			String[] refColumns) {
		getSource().pushJoin(joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		getSource().pushJoin(joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns,
			String alias) {
		getSource().pushJoin(joinType, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushNullCondition(String table, String column) {
		getSource().pushNullCondition(table, column);
	}

	@Override
	public void pushNotNullCondition(String table, String column) {
		getSource().pushNotNullCondition(table, column);
	}

	@Override
	public void pushCondition(String table, String column, String statment) {
		getSource().pushCondition(table, column, statment);
	}

	@Override
	public void pushEqualByte(String table, String column, Byte value) {
		getSource().pushEqualByte(table, column, value);
	}

	@Override
	public void pushEqualShort(String table, String column, Short value) {
		getSource().pushEqualShort(table, column, value);
	}

	@Override
	public void pushEqualInteger(String table, String column, Integer value) {
		getSource().pushEqualInteger(table, column, value);
	}

	@Override
	public void pushEqualLong(String table, String column, Long value) {
		getSource().pushEqualLong(table, column, value);
	}

	@Override
	public void pushEqualFloat(String table, String column, Float value) {
		getSource().pushEqualFloat(table, column, value);
	}

	@Override
	public void pushEqualDouble(String table, String column, Double value) {
		getSource().pushEqualDouble(table, column, value);
	}

	@Override
	public void pushEqualString(String table, String column, String value) {
		getSource().pushEqualString(table, column, value);
	}

	@Override
	public void pushArgument(String table, String column, ConditionType condition, Object arg) {
		getSource().pushArgument(table, column, condition, arg);
	}

	@Override
	public void pushArguments(String table, String column, Object[] values) {
		getSource().pushArguments(table, column, values);
	}

	@Override
	public void pushArguments(String[] tables, String[] columns, Object value) {
		getSource().pushArguments(tables, columns, value);
	}

	@Override
	public void pushFuzzySearch(String table, String column, String value) {
		getSource().pushFuzzySearch(table, column, value);
	}

	@Override
	public void pushFuzzySearch(String[] tables, String[] columns, String value) {
		getSource().pushFuzzySearch(tables, columns, value);
	}

	@Override
	public void pushEqualDate(String table, String column, Date value) {
		getSource().pushEqualDate(table, column, value);
	}

	@Override
	public void pushEqualDateTime(String table, String column, Date value) {
		getSource().pushEqualDateTime(table, column, value);
	}

	@Override
	public void pushLargeThenDate(String table, String column, Date value) {
		getSource().pushLargeThenDate(table, column, value);
	}

	@Override
	public void pushLargeThenDateTime(String table, String column, Date value) {
		getSource().pushLargeThenDateTime(table, column, value);
	}

	@Override
	public void pushSmallThenDate(String table, String column, Date value) {
		getSource().pushSmallThenDate(table, column, value);
	}

	@Override
	public void pushSmallThenDateTime(String table, String column, Date value) {
		getSource().pushSmallThenDateTime(table, column, value);
	}

	@Override
	public void pushBetweenDate(String table, String column, Date start, Date end) {
		getSource().pushBetweenDate(table, column, start, end);
	}

	@Override
	public void pushBetweenDateTime(String table, String column, Date start, Date end) {
		getSource().pushBetweenDateTime(table, column, start, end);
	}

	@Override
	public void pushLargeThenDateAndNull(String table, String column, Date value) {
		getSource().pushLargeThenDateAndNull(table, column, value);
	}

	@Override
	public void pushLargeThenDateTimeAndNull(String table, String column, Date value) {
		getSource().pushLargeThenDateTimeAndNull(table, column, value);
	}

	@Override
	public void pushSmallThenDateAndNull(String table, String column, Date value) {
		getSource().pushSmallThenDateAndNull(table, column, value);
	}

	@Override
	public void pushSmallThenDateTimeAndNull(String table, String column, Date value) {
		getSource().pushSmallThenDateTimeAndNull(table, column, value);
	}

	@Override
	public String getOpenQuote() {
		return getSource().getOpenQuote();
	}

	@Override
	public String getCloseQuote() {
		return getSource().getCloseQuote();
	}

	@Override
	public String quoted(String text) {
		return getSource().quoted(text);
	}

	@Override
	public String quoted(String table, String column) {
		return getSource().quoted(table, column);
	}

	@Override
	public void setRawFrom(String key, String sql) {
		getSource().setRawFrom(key, sql);
	}

	@Override
	public void unshiftRawJoin(String key, String sql) {
		getSource().unshiftRawJoin(key, sql);
	}

	@Override
	public void pushRawJoin(String key, String sql) {
		getSource().pushRawJoin(key, sql);
	}

	@Override
	public JoinStatement getRawJoin(String key) {
		return getSource().getRawJoin(key);
	}

	@Override
	public void refreshRawJoin(String key, String sql) {
		getSource().refreshRawJoin(key, sql);
	}

	@Override
	public void pushRawAlias(String sql) {
		getSource().pushRawAlias(sql);
	}

	@Override
	public void pushRawSelection(String sql) {
		getSource().pushRawSelection(sql);
	}

	@Override
	public void unshiftRawGroup(String sql) {
		getSource().unshiftRawGroup(sql);
	}

	@Override
	public void pushRawGroup(String sql) {
		getSource().pushRawGroup(sql);
	}

	@Override
	public void unshiftRawSort(String sql) {
		getSource().unshiftRawSort(sql);
	}

	@Override
	public void pushRawSort(String sql) {
		getSource().pushRawSort(sql);
	}

	@Override
	public void pushRawCondition(String sql) {
		getSource().pushRawCondition(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getSource().pushRawArg(arg);
	}

	@Override
	public void mergeRawArg(Object[] args) {
		getSource().mergeRawArg(args);
	}

}

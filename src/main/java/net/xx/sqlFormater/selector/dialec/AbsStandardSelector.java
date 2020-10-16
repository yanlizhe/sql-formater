package net.xx.sqlFormater.selector.dialec;

import java.util.Date;

import net.xx.sqlFormater.enumerate.ConditionType;
import net.xx.sqlFormater.enumerate.JoinType;
import net.xx.sqlFormater.selector.StandardSelector;
import net.xx.sqlFormater.statement.GeneralStatementRead;
import net.xx.sqlFormater.statement.StandardStatementRead;
import net.xx.sqlFormater.statement.StandardStatementReadWrapper;

abstract class AbsStandardSelector extends AbsGeneralSelector implements StandardSelector {

	@Override
	public final GeneralStatementRead getGeneralStatementRead() {
		StandardStatementRead statement = getStandardStatementRead();
		if (null != statement && statement instanceof StandardStatementReadWrapper) {
			statement = ((StandardStatementReadWrapper) statement).getSource();
		}
		return (GeneralStatementRead) statement;
	}
	
	@Override
	public final void setGeneralStatementRead(GeneralStatementRead generalStatementRead) {
		setStandardStatementRead((StandardStatementRead) generalStatementRead);
	}
	
	

	@Override
	public void pushSelection(String table, String column, String alias) {
		final StringBuilder as = new StringBuilder();
		as.append(getOpenQuote());
		as.append(alias);
		as.append(getCloseQuote());
		pushRawAlias(as.toString());
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" as ");
		sql.append(as);
		pushRawSelection(sql.toString());
	}

	@Override
	public void pushOperationSelection(String operation, String alias) {
		final StringBuilder as = new StringBuilder();
		as.append(getOpenQuote());
		as.append(alias);
		as.append(getCloseQuote());
		pushRawAlias(as.toString());
		final StringBuilder sql = new StringBuilder();
		sql.append(operation);
		sql.append(" as ");
		sql.append(as);
		pushRawSelection(sql.toString());
	}

	@Override
	public void setTable(String table) {
		getStandardStatementRead().setTable(table);
	}

	@Override
	public void setTable(String table, String alias) {
		getStandardStatementRead().setTable(table, alias);
	}

	@Override
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn) {
		getStandardStatementRead().unshiftJoin(joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		getStandardStatementRead().unshiftJoin(joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		getStandardStatementRead().unshiftJoin(joinType, joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		getStandardStatementRead().unshiftJoin(joinType, joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		getStandardStatementRead().unshiftJoin(joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		getStandardStatementRead().unshiftJoin(joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		getStandardStatementRead().unshiftJoin(joinType, joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		getStandardStatementRead().unshiftJoin(joinType, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn) {
		getStandardStatementRead().pushJoin(joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		getStandardStatementRead().pushJoin(joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		getStandardStatementRead().pushJoin(joinType, joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		getStandardStatementRead().pushJoin(joinType, joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		getStandardStatementRead().pushJoin(joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		getStandardStatementRead().pushJoin(joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		getStandardStatementRead().pushJoin(joinType, joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		getStandardStatementRead().pushJoin(joinType, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushNullCondition(String table, String column) {
		getStandardStatementRead().pushNullCondition(table, column);
	}

	@Override
	public void pushNotNullCondition(String table, String column) {
		getStandardStatementRead().pushNotNullCondition(table, column);
	}

	@Override
	public void pushCondition(String table, String column, String statment) {
		getStandardStatementRead().pushCondition(table, column, statment);
	}

	@Override
	public void pushEqualByte(String table, String column, Byte value) {
		getStandardStatementRead().pushEqualByte(table, column, value);
	}

	@Override
	public void pushEqualShort(String table, String column, Short value) {
		getStandardStatementRead().pushEqualShort(table, column, value);
	}

	@Override
	public void pushEqualInteger(String table, String column, Integer value) {
		getStandardStatementRead().pushEqualInteger(table, column, value);
	}

	@Override
	public void pushEqualLong(String table, String column, Long value) {
		getStandardStatementRead().pushEqualLong(table, column, value);
	}

	@Override
	public void pushEqualFloat(String table, String column, Float value) {
		getStandardStatementRead().pushEqualFloat(table, column, value);
	}

	@Override
	public void pushEqualDouble(String table, String column, Double value) {
		getStandardStatementRead().pushEqualDouble(table, column, value);
	}

	@Override
	public void pushEqualString(String table, String column, String value) {
		getStandardStatementRead().pushEqualString(table, column, value);
	}

	@Override
	public void pushArgument(String table, String column, ConditionType condition, Object arg) {
		getStandardStatementRead().pushArgument(table, column, condition, arg);
	}

	@Override
	public void pushArguments(String table, String column, Object[] values) {
		getStandardStatementRead().pushArguments(table, column, values);
	}
	
	@Override
	public void pushArguments(String[] tables, String[] columns, Object value) {
		getStandardStatementRead().pushArguments(tables, columns, value);
	}

	@Override
	public void pushFuzzySearch(String table, String column, String value) {
		getStandardStatementRead().pushFuzzySearch(table, column, value);
	}

	@Override
	public void pushFuzzySearch(String[] tables, String[] columns, String value) {
		getStandardStatementRead().pushFuzzySearch(tables, columns, value);
	}

	@Override
	public void pushEqualDate(String table, String column, Date value) {
		getStandardStatementRead().pushEqualDate(table, column, value);
	}

	@Override
	public void pushEqualDateTime(String table, String column, Date value) {
		getStandardStatementRead().pushEqualDateTime(table, column, value);
	}

	@Override
	public void pushLargeThenDate(String table, String column, Date value) {
		getStandardStatementRead().pushLargeThenDate(table, column, value);
	}

	@Override
	public void pushLargeThenDateTime(String table, String column, Date value) {
		getStandardStatementRead().pushLargeThenDateTime(table, column, value);
	}

	@Override
	public void pushSmallThenDate(String table, String column, Date value) {
		getStandardStatementRead().pushSmallThenDate(table, column, value);
	}

	@Override
	public void pushSmallThenDateTime(String table, String column, Date value) {
		getStandardStatementRead().pushSmallThenDateTime(table, column, value);
	}

	@Override
	public void pushLargeThenDateAndNull(String table, String column, Date value) {
		getStandardStatementRead().pushLargeThenDateAndNull(table, column, value);
	}

	@Override
	public void pushLargeThenDateTimeAndNull(String table, String column, Date value) {
		getStandardStatementRead().pushLargeThenDateTimeAndNull(table, column, value);
	}

	@Override
	public void pushSmallThenDateAndNull(String table, String column, Date value) {
		getStandardStatementRead().pushSmallThenDateAndNull(table, column, value);
	}

	@Override
	public void pushSmallThenDateTimeAndNull(String table, String column, Date value) {
		getStandardStatementRead().pushSmallThenDateTimeAndNull(table, column, value);
	}

	@Override
	public void pushBetweenDate(String table, String column, Date start, Date end) {
		getStandardStatementRead().pushBetweenDate(table, column, start, end);
	}

	@Override
	public void pushBetweenDateTime(String table, String column, Date start, Date end) {
		getStandardStatementRead().pushBetweenDateTime(table, column, start, end);
	}

	@Override
	public void unshiftGroup(String table, String column) {
		unshiftRawGroup(formatGroup(table, column));
	}

	@Override
	public void pushGroup(String table, String column) {
		pushRawGroup(formatGroup(table, column));
	}

	@Override
	public void unshiftSort(String table, String column) {
		unshiftSort(table, column, true);
	}

	@Override
	public void unshiftSort(String table, String column, boolean isAsc) {
		unshiftRawSort(formatSort(table, column, isAsc));
	}

	@Override
	public void pushSort(String table, String column) {
		pushSort(table, column, true);
	}

	@Override
	public void pushSort(String table, String column, boolean isAsc) {
		pushRawSort(formatSort(table, column, isAsc));
	}
	
	private String formatGroup(String table, String column) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		return sql.toString();
	}
	
	private String formatSort(String table, String column, boolean isAsc) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		if(isAsc) {
			sql.append(" asc");
		} else {
			sql.append(" desc");
		}
		return sql.toString();
	}

}

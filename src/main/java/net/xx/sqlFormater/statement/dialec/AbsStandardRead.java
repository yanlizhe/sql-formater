package net.xx.sqlFormater.statement.dialec;

import java.util.Date;

import org.springframework.util.StringUtils;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.enumerate.ConditionType;
import net.xx.sqlFormater.enumerate.JoinType;
import net.xx.sqlFormater.filter.GeneralFilterReadable;
import net.xx.sqlFormater.filter.StandardFilterReadable;
import net.xx.sqlFormater.filter.StandardFilterReadableWrapper;
import net.xx.sqlFormater.selector.GeneralSelector;
import net.xx.sqlFormater.selector.StandardSelector;
import net.xx.sqlFormater.selector.StandardSelectorWrapper;
import net.xx.sqlFormater.statement.StandardStatementRead;

abstract class AbsStandardRead extends AbsGeneralRead implements StandardStatementRead {

	protected AbsStandardRead(StandardSelector selector, StandardFilterReadable filter) {
		super(null, null);
		if (null != selector) {
			setStandardSelector(selector);
		}
		if (null != filter) {
			setStandardFilterReadable(filter);
		}
	}

	protected AbsStandardRead(String selector, String filter, String formater) {
		super(null, null, formater);
		if(SqlBeanFactory.hasName(selector)) {
			setStandardSelector(SqlBeanFactory.getBean(selector, StandardSelector.class));
		}
		if(SqlBeanFactory.hasName(filter)) {
			setStandardFilterReadable(SqlBeanFactory.getBean(filter, StandardFilterReadable.class));
		}
	}

	@Override
	public final GeneralSelector getGeneralSelector() {
		StandardSelector selector = getStandardSelector();
		if (selector instanceof StandardSelectorWrapper) {
			selector = ((StandardSelectorWrapper) selector).getSource();
		}
		return (GeneralSelector) selector;
	}
	
	@Override
	public final void setGeneralSelector(GeneralSelector generalSelector) {
		setStandardSelector((StandardSelector) generalSelector);
	}

	@Override
	public final GeneralFilterReadable getGeneralFilterReadable() {
		StandardFilterReadable filter = getStandardFilterReadable();
		if (filter instanceof StandardFilterReadableWrapper) {
			filter = ((StandardFilterReadableWrapper) filter).getSource();
		}
		return (GeneralFilterReadable) filter;
	}
	
	@Override
	public final void setGeneralFilterReadable(GeneralFilterReadable generalFilterReadable) {
		setStandardFilterReadable((StandardFilterReadable) generalFilterReadable);
	}

	

	@Override
	public void pushSelection(String table, String column, String alias) {
		getStandardSelector().pushSelection(table, column, alias);
	}

	@Override
	public void pushOperationSelection(String operation, String alias) {
		getStandardSelector().pushOperationSelection(operation, alias);
	}
	
	@Override
	public void setTable(String table) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		setRawFrom(table, sql.toString());
	}
	
	@Override
	public void setTable(String table, String alias) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(" ");
		sql.append(getOpenQuote());
		sql.append(alias);
		sql.append(getCloseQuote());
		setRawFrom(table, sql.toString());
	}

	@Override
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn) {
		addJoin(true, JoinType.Left, joinTable, new String[] {joinColumn}, refTable, new String[]{refColumn}, null);
	}

	@Override
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		addJoin(true, JoinType.Left, joinTable, new String[] {joinColumn}, refTable, new String[]{refColumn}, alias);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		addJoin(true, joinType, joinTable, new String[] {joinColumn}, refTable, new String[]{refColumn}, null);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		addJoin(true, joinType, joinTable, new String[] {joinColumn}, refTable, new String[]{refColumn}, alias);
	}

	@Override
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		addJoin(true, JoinType.Left, joinTable, joinColumns, refTable, refColumns, null);
	}

	@Override
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		addJoin(true, JoinType.Left, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		addJoin(true, joinType, joinTable, joinColumns, refTable, refColumns, null);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		addJoin(true, joinType, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn) {
		addJoin(false, JoinType.Left, joinTable, new String[] {joinColumn}, refTable, new String[]{refColumn}, null);
	}

	@Override
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		addJoin(false, JoinType.Left, joinTable, new String[] {joinColumn}, refTable, new String[]{refColumn}, alias);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		addJoin(false, joinType, joinTable, new String[] {joinColumn}, refTable, new String[]{refColumn}, null);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		addJoin(false, joinType, joinTable, new String[] {joinColumn}, refTable, new String[]{refColumn}, alias);
	}

	@Override
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		addJoin(false, JoinType.Left, joinTable, joinColumns, refTable, refColumns, null);
	}

	@Override
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		addJoin(false, JoinType.Left, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		addJoin(false, joinType, joinTable, joinColumns, refTable, refColumns, null);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		addJoin(false, joinType, joinTable, joinColumns, refTable, refColumns, alias);
	}

	private void addJoin(boolean inFront, JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		String key;
		if(StringUtils.isEmpty(alias)) {
			key = joinTable;
		} else {
			key = alias;
		}
		final StringBuilder sql = new StringBuilder();
		if(null != joinType) {
			switch (joinType) {
			case Inner:
				sql.append("inner ");
				break;
			case Left:
				sql.append("left ");
				break;
			case Right:
				sql.append("right ");
				break;
			case Full:
				sql.append("full ");
				break;
			default:
			}
		}
		sql.append("join ");
		sql.append(getOpenQuote());
		sql.append(joinTable);
		sql.append(getCloseQuote());
		if(!StringUtils.isEmpty(alias)) {
			sql.append(" ");
			sql.append(getOpenQuote());
			sql.append(alias);
			sql.append(getCloseQuote());
		}
		sql.append(" on ");
		for(int i = 0; i < refColumns.length; i++) {
			if(i > 0) {
				sql.append(" and ");
			}
			sql.append(getOpenQuote());
			sql.append(key);
			sql.append(getCloseQuote());
			sql.append(".");
			sql.append(getOpenQuote());
			sql.append(joinColumns[i]);
			sql.append(getCloseQuote());
			sql.append(" = ");
			sql.append(getOpenQuote());
			sql.append(refTable);
			sql.append(getCloseQuote());
			sql.append(".");
			sql.append(getOpenQuote());
			sql.append(refColumns[i]);
			sql.append(getCloseQuote());
		}
		if(inFront) {
			unshiftRawJoin(key, sql.toString());
		} else {
			pushRawJoin(key, sql.toString());
		}
	}

	@Override
	public void pushNullCondition(String table, String column) {
		getStandardFilterReadable().pushNullCondition(table, column);
	}

	@Override
	public void pushNotNullCondition(String table, String column) {
		getStandardFilterReadable().pushNotNullCondition(table, column);
	}

	@Override
	public void pushCondition(String table, String column, String statment) {
		getStandardFilterReadable().pushCondition(table, column, statment);
	}

	@Override
	public void pushFuzzySearch(String table, String column, String value) {
		getStandardFilterReadable().pushFuzzySearch(table, column, value);
	}

	@Override
	public void pushFuzzySearch(String[] tables, String[] columns, String value) {
		getStandardFilterReadable().pushFuzzySearch(tables, columns, value);
	}

	@Override
	public void pushEqualDate(String table, String column, Date value) {
		getStandardFilterReadable().pushEqualDate(table, column, value);
	}

	@Override
	public void pushEqualDateTime(String table, String column, Date value) {
		getStandardFilterReadable().pushEqualDateTime(table, column, value);
	}

	@Override
	public void pushLargeThenDate(String table, String column, Date value) {
		getStandardFilterReadable().pushLargeThenDate(table, column, value);
	}

	@Override
	public void pushLargeThenDateTime(String table, String column, Date value) {
		getStandardFilterReadable().pushLargeThenDateTime(table, column, value);
	}

	@Override
	public void pushSmallThenDate(String table, String column, Date value) {
		getStandardFilterReadable().pushSmallThenDate(table, column, value);
	}

	@Override
	public void pushSmallThenDateTime(String table, String column, Date value) {
		getStandardFilterReadable().pushSmallThenDateTime(table, column, value);
	}

	@Override
	public void pushLargeThenDateAndNull(String table, String column, Date value) {
		getStandardFilterReadable().pushLargeThenDateAndNull(table, column, value);
	}

	@Override
	public void pushLargeThenDateTimeAndNull(String table, String column, Date value) {
		getStandardFilterReadable().pushLargeThenDateTimeAndNull(table, column, value);
	}

	@Override
	public void pushSmallThenDateAndNull(String table, String column, Date value) {
		getStandardFilterReadable().pushSmallThenDateAndNull(table, column, value);
	}

	@Override
	public void pushSmallThenDateTimeAndNull(String table, String column, Date value) {
		getStandardFilterReadable().pushSmallThenDateTimeAndNull(table, column, value);
	}

	@Override
	public void pushBetweenDate(String table, String column, Date start, Date end) {
		getStandardFilterReadable().pushBetweenDate(table, column, start, end);
	}

	@Override
	public void pushBetweenDateTime(String table, String column, Date start, Date end) {
		getStandardFilterReadable().pushBetweenDateTime(table, column, start, end);
	}

	@Override
	public void pushEqualByte(String table, String column, Byte value) {
		getStandardFilterReadable().pushEqualByte(table, column, value);
	}

	@Override
	public void pushEqualShort(String table, String column, Short value) {
		getStandardFilterReadable().pushEqualShort(table, column, value);
	}

	@Override
	public void pushEqualInteger(String table, String column, Integer value) {
		getStandardFilterReadable().pushEqualInteger(table, column, value);
	}

	@Override
	public void pushEqualLong(String table, String column, Long value) {
		getStandardFilterReadable().pushEqualLong(table, column, value);
	}

	@Override
	public void pushEqualFloat(String table, String column, Float value) {
		getStandardFilterReadable().pushEqualFloat(table, column, value);
	}

	@Override
	public void pushEqualDouble(String table, String column, Double value) {
		getStandardFilterReadable().pushEqualDouble(table, column, value);
	}

	@Override
	public void pushEqualString(String table, String column, String value) {
		getStandardFilterReadable().pushEqualString(table, column, value);
	}

	@Override
	public void pushArgument(String table, String column, ConditionType condition, Object arg) {
		getStandardFilterReadable().pushArgument(table, column, condition, arg);
	}

	@Override
	public void pushArguments(String table, String column, Object[] values) {
		getStandardFilterReadable().pushArguments(table, column, values);
	}

	@Override
	public void pushArguments(String[] tables, String[] columns, Object value) {
		getStandardFilterReadable().pushArguments(tables, columns, value);
	}

	@Override
	public void unshiftGroup(String table, String column) {
		getStandardSelector().unshiftGroup(table, column);
	}

	@Override
	public void pushGroup(String table, String column) {
		getStandardSelector().pushGroup(table, column);
	}

	@Override
	public void unshiftSort(String table, String column) {
		getStandardSelector().unshiftSort(table, column);
	}

	@Override
	public void unshiftSort(String table, String column, boolean isAsc) {
		getStandardSelector().unshiftSort(table, column, isAsc);
	}

	@Override
	public void pushSort(String table, String column) {
		getStandardSelector().pushSort(table, column);
	}

	@Override
	public void pushSort(String table, String column, boolean isAsc) {
		getStandardSelector().pushSort(table, column, isAsc);
	}

}

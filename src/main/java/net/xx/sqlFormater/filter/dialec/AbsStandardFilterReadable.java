package net.xx.sqlFormater.filter.dialec;

import java.util.Date;

import org.springframework.util.StringUtils;

import net.xx.sqlFormater.enumerate.ConditionType;
import net.xx.sqlFormater.enumerate.JoinType;
import net.xx.sqlFormater.filter.StandardFilterReadable;
import net.xx.sqlFormater.statement.GeneralStatement;
import net.xx.sqlFormater.statement.StandardStatement;
import net.xx.sqlFormater.statement.StandardStatementRead;
import net.xx.sqlFormater.statement.StandardStatementReadWrapper;

public abstract class AbsStandardFilterReadable extends AbsGeneralFilter implements StandardFilterReadable {

	@Override
	public final StandardStatementRead getStandardStatementRead() {
		return (StandardStatementRead) getStandardStatement();
	}
	
	@Override
	public final void setStandardStatementRead(StandardStatementRead standardStatementRead) {
		setStandardStatement((StandardStatement) standardStatementRead);
	}

	@Override
	public final GeneralStatement getGeneralStatement() {
		StandardStatement statement = getStandardStatement();
		if (null != statement && statement instanceof StandardStatementReadWrapper) {
			statement = ((StandardStatementReadWrapper) statement).getSource();
		}
		return (GeneralStatement) statement;
	}
	
	@Override
	public final void setGeneralStatement(GeneralStatement generalStatement) {
		setStandardStatement((StandardStatement) generalStatement);
	}



	@Override
	public void pushSelection(String table, String column, String alias) {
		getStandardStatementRead().pushSelection(table, column, alias);
	}

	@Override
	public void pushOperationSelection(String operation, String alias) {
		getStandardStatementRead().pushOperationSelection(operation, alias);
	}

	@Override
	public void setTable(String table) {
		getStandardStatementRead().setTable(table);
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
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		getStandardStatementRead().pushJoin(joinType, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		getStandardStatementRead().unshiftJoin(joinType, joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable,
			String[] refColumns) {
		getStandardStatementRead().unshiftJoin(joinType, joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		getStandardStatementRead().pushJoin(joinType, joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable,
			String[] refColumns) {
		getStandardStatementRead().pushJoin(joinType, joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void pushNullCondition(String table, String column) {
		pushCondition(table, column, "is null");
	}

	@Override
	public void pushNotNullCondition(String table, String column) {
		pushCondition(table, column, "is not null");
	}

	@Override
	public void pushCondition(String table, String column, String statment) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" ");
		sql.append(statment);
		pushRawCondition(sql.toString());
	}

	@Override
	public void pushEqualByte(String table, String column, Byte value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			pushArgument(table, column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualShort(String table, String column, Short value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			pushArgument(table, column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualInteger(String table, String column, Integer value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			pushArgument(table, column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualLong(String table, String column, Long value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			pushArgument(table, column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualFloat(String table, String column, Float value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			pushArgument(table, column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualDouble(String table, String column, Double value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			pushArgument(table, column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualString(String table, String column, String value) {
		if (StringUtils.isEmpty(value)) {
			pushNullCondition(table, column);
		} else {
			pushArgument(table, column, ConditionType.Equal, value);
		}
	}

	protected abstract void doPushEqualDate(String table, String column, Date value);

	@Override
	public final void pushEqualDate(String table, String column, Date value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			doPushEqualDate(table, column, value);
		}
	}

	protected abstract void doPushEqualDateTime(String table, String column, Date value);

	@Override
	public final void pushEqualDateTime(String table, String column, Date value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			doPushEqualDateTime(table, column, value);
		}
	}

	protected abstract void doPushLargeThenDate(String table, String column, Date value);

	@Override
	public final void pushLargeThenDate(String table, String column, Date value) {
		if (null != value) {
			doPushLargeThenDate(table, column, value);
		}
	}

	protected abstract void doPushLargeThenDateAndNull(String table, String column, Date value);

	@Override
	public final void pushLargeThenDateAndNull(String table, String column, Date value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			doPushLargeThenDateAndNull(table, column, value);
		}
	}

	protected abstract void doPushLargeThenDateTime(String table, String column, Date value);

	@Override
	public final void pushLargeThenDateTime(String table, String column, Date value) {
		if (null != value) {
			doPushLargeThenDateTime(table, column, value);
		}
	}

	protected abstract void doPushLargeThenDateTimeAndNull(String table, String column, Date value);

	@Override
	public final void pushLargeThenDateTimeAndNull(String table, String column, Date value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			doPushLargeThenDateTimeAndNull(table, column, value);
		}
	}

	protected abstract void doPushSmallThenDate(String table, String column, Date value);

	@Override
	public final void pushSmallThenDate(String table, String column, Date value) {
		if (null != value) {
			doPushSmallThenDate(table, column, value);
		}
	}

	protected abstract void doPushSmallThenDateAndNull(String table, String column, Date value);

	@Override
	public void pushSmallThenDateAndNull(String table, String column, Date value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			doPushSmallThenDateAndNull(table, column, value);
		}
	}

	protected abstract void doPushSmallThenDateTime(String table, String column, Date value);

	@Override
	public final void pushSmallThenDateTime(String table, String column, Date value) {
		if (null != value) {
			doPushSmallThenDateTime(table, column, value);
		}
	}

	protected abstract void doPushSmallThenDateTimeAndNull(String table, String column, Date value);

	@Override
	public void pushSmallThenDateTimeAndNull(String table, String column, Date value) {
		if (null == value) {
			pushNullCondition(table, column);
		} else {
			doPushSmallThenDateTimeAndNull(table, column, value);
		}
	}

	protected abstract void doPushBetweenDate(String table, String column, Date start, Date end);

	@Override
	public final void pushBetweenDate(String table, String column, Date start, Date end) {
		if (null == start && null != end) {
			doPushSmallThenDate(table, column, end);
		} else if (null != start && null == end) {
			doPushLargeThenDate(table, column, start);
		} else if (null != start && null != end) {
			doPushBetweenDate(table, column, start, end);
		}
	}

	protected abstract void doPushBetweenDateTime(String table, String column, Date start, Date end);

	@Override
	public final void pushBetweenDateTime(String table, String column, Date start, Date end) {
		if (null == start && null != end) {
			doPushSmallThenDateTime(table, column, end);
		} else if (null != start && null == end) {
			doPushLargeThenDateTime(table, column, start);
		} else if (null != start && null != end) {
			doPushBetweenDateTime(table, column, start, end);
		}
	}

	@Override
	public void pushFuzzySearch(String table, String column, String value) {
		pushFuzzySearch(new String[] {table}, new String[] {column}, value);
	}

	@Override
	public void pushFuzzySearch(String[] tables, String[] columns, String value) {
		final StringBuilder sql = new StringBuilder();
		if(tables.length > 1) {
			sql.append("(");
		}
		for(int i = 0; i < tables.length; i++) {
			if(i > 0) {
				sql.append(" or ");
			}
			sql.append(getOpenQuote());
			sql.append(tables[i]);
			sql.append(getCloseQuote());
			sql.append(".");
			sql.append(getOpenQuote());
			sql.append(columns[i]);
			sql.append(getCloseQuote());
			sql.append(" like ?");
			pushRawArg("%" + value + "%");
		}
		if(tables.length > 1) {
			sql.append(")");
		}
		pushRawCondition(sql.toString());
	}
	
	@Override
	public void pushArgument(String table, String column, ConditionType condition, Object arg) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		if (null != condition) {
			switch (condition) {
			case Equal:
				sql.append(" =");
				break;
			case NotEqual:
				sql.append(" <>");
				break;
			case Large:
				sql.append(" >");
				break;
			case LargeThen:
				sql.append(" >=");
				break;
			case Small:
				sql.append(" <");
				break;
			case SmallThen:
				sql.append(" <=");
				break;
			default:
			}
		}
		sql.append(" ?");
		pushRawCondition(sql.toString());
		pushRawArg(arg);
	}

	@Override
	public void pushArguments(String table, String column, Object[] values) {
		if (null != values) {
			final StringBuilder sql = new StringBuilder();
			if(values.length > 1) {
				sql.append("(");
			}
			for(int i = 0; i < values.length; i++) {
				if(i > 0) {
					sql.append(" or ");
				}
				sql.append(getOpenQuote());
				sql.append(table);
				sql.append(getCloseQuote());
				sql.append(".");
				sql.append(getOpenQuote());
				sql.append(column);
				sql.append(getCloseQuote());
				if (null == values[i]) {
					sql.append(" is null");
				} else {
					sql.append(" = ?");
					pushRawArg(values[i]);
				}
			}
			if(values.length > 1) {
				sql.append(")");
			}
			pushRawCondition(sql.toString());
		}
	}

	@Override
	public void pushArguments(String[] tables, String[] columns, Object value) {
		final StringBuilder sql = new StringBuilder();
		if(tables.length > 1) {
			sql.append("(");
		}
		for(int i = 0; i < tables.length; i++) {
			if(i > 0) {
				sql.append(" or ");
			}
			sql.append(getOpenQuote());
			sql.append(tables[i]);
			sql.append(getCloseQuote());
			sql.append(".");
			sql.append(getOpenQuote());
			sql.append(columns[i]);
			sql.append(getCloseQuote());
			if (null == value) {
				sql.append(" is null");
			} else {
				sql.append(" = ?");
				pushRawArg(value);
			}
		}
		if(tables.length > 1) {
			sql.append(")");
		}
		pushRawCondition(sql.toString());
	}

	@Override
	public void unshiftGroup(String table, String column) {
		getStandardStatementRead().unshiftGroup(table, column);
	}

	@Override
	public void pushGroup(String table, String column) {
		getStandardStatementRead().pushGroup(table, column);
	}

	@Override
	public void unshiftSort(String table, String column) {
		getStandardStatementRead().unshiftSort(table, column);
	}

	@Override
	public void unshiftSort(String table, String column, boolean isAsc) {
		getStandardStatementRead().unshiftSort(table, column, isAsc);
	}

	@Override
	public void pushSort(String table, String column) {
		getStandardStatementRead().pushSort(table, column);
	}

	@Override
	public void pushSort(String table, String column, boolean isAsc) {
		getStandardStatementRead().pushSort(table, column, isAsc);
	}

}

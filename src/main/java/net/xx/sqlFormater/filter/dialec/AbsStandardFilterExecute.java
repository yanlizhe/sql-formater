package net.xx.sqlFormater.filter.dialec;

import java.util.Date;

import org.springframework.util.StringUtils;

import net.xx.sqlFormater.enumerate.ConditionType;
import net.xx.sqlFormater.filter.StandardFilterExecute;
import net.xx.sqlFormater.statement.GeneralStatement;
import net.xx.sqlFormater.statement.StandardStatement;
import net.xx.sqlFormater.statement.StandardStatementDeleteWrapper;
import net.xx.sqlFormater.statement.StandardStatementExecute;
import net.xx.sqlFormater.statement.StandardStatementUpdateWrapper;

public abstract class AbsStandardFilterExecute extends AbsGeneralFilter implements StandardFilterExecute {

	@Override
	public final StandardStatementExecute getStandardStatementExecute() {
		return (StandardStatementExecute) getStandardStatement();
	}

	@Override
	public final void setStandardStatementExecute(StandardStatementExecute standardStatementExecute) {
		setStandardStatement((StandardStatement) standardStatementExecute);
	}

	@Override
	public final GeneralStatement getGeneralStatement() {
		StandardStatement statement = getStandardStatement();
		if (null != statement) {
			if (statement instanceof StandardStatementUpdateWrapper) {
				statement = ((StandardStatementUpdateWrapper) statement).getSource();
			} else if (statement instanceof StandardStatementDeleteWrapper) {
				statement = ((StandardStatementDeleteWrapper) statement).getSource();
			}
		}
		return (GeneralStatement) statement;
	}
	
	@Override
	public final void setGeneralStatement(GeneralStatement generalStatement) {
		setStandardStatement((StandardStatement) generalStatement);
	}

	@Override
	public void setTable(String table) {
		getStandardStatementExecute().setTable(table);
	}

	@Override
	public void setNullValue(String column) {
		getStandardStatementExecute().setNullValue(column);
	}

	@Override
	public void setValue(String column, Object value) {
		getStandardStatementExecute().setValue(column, value);;
	}

	@Override
	public void setByteValue(String column, Byte value) {
		getStandardStatementExecute().setByteValue(column, value);
	}

	@Override
	public void setShortValue(String column, Short value) {
		getStandardStatementExecute().setShortValue(column, value);
	}

	@Override
	public void setIntegerValue(String column, Integer value) {
		getStandardStatementExecute().setIntegerValue(column, value);
	}

	@Override
	public void setLongValue(String column, Long value) {
		getStandardStatementExecute().setLongValue(column, value);
	}

	@Override
	public void setFloatValue(String column, Float value) {
		getStandardStatementExecute().setFloatValue(column, value);
	}

	@Override
	public void setDoubleValue(String column, Double value) {
		getStandardStatementExecute().setDoubleValue(column, value);
	}

	@Override
	public void setStringValue(String column, String value) {
		getStandardStatementExecute().setStringValue(column, value);
	}

	@Override
	public void setDateValue(String column, Date value) {
		getStandardStatementExecute().setDateValue(column, value);
	}

	@Override
	public void setDateTimeValue(String column) {
		getStandardStatementExecute().setDateTimeValue(column);
	}

	@Override
	public void setDateTimeValue(String column, Date value) {
		getStandardStatementExecute().setDateTimeValue(column, value);
	}

	@Override
	public void setTimestampValue(String column) {
		getStandardStatementExecute().setTimestampValue(column);
	}

	@Override
	public void pushNullCondition(String column) {
		pushCondition(column, "is null");
	}

	@Override
	public void pushNotNullCondition(String column) {
		pushCondition(column, "is not null");
	}

	@Override
	public void pushCondition(String column, String statment) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" ");
		sql.append(statment);
		pushRawCondition(sql.toString());
	}

	@Override
	public void pushEqualByte(String column, Byte value) {
		if (null == value) {
			pushNullCondition(column);
		} else {
			pushArgument(column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualShort(String column, Short value) {
		if (null == value) {
			pushNullCondition(column);
		} else {
			pushArgument(column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualInteger(String column, Integer value) {
		if (null == value) {
			pushNullCondition(column);
		} else {
			pushArgument(column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualLong(String column, Long value) {
		if (null == value) {
			pushNullCondition(column);
		} else {
			pushArgument(column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualFloat(String column, Float value) {
		if (null == value) {
			pushNullCondition(column);
		} else {
			pushArgument(column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualDouble(String column, Double value) {
		if (null == value) {
			pushNullCondition(column);
		} else {
			pushArgument(column, ConditionType.Equal, value);
		}
	}

	@Override
	public void pushEqualString(String column, String value) {
		if (StringUtils.isEmpty(value)) {
			pushNullCondition(column);
		} else {
			pushArgument(column, ConditionType.Equal, value);
		}
	}

	protected abstract void doPushEqualDate(String column, Date value);

	@Override
	public final void pushEqualDate(String column, Date value) {
		if (null == value) {
			pushNullCondition(column);
		} else {
			doPushEqualDate(column, value);
		}
	}

	protected abstract void doPushEqualDateTime(String column, Date value);

	@Override
	public final void pushEqualDateTime(String column, Date value) {
		if (null == value) {
			pushNullCondition(column);
		} else {
			doPushEqualDateTime(column, value);
		}
	}

	protected abstract void doPushLargeThenDate(String column, Date value);

	@Override
	public final void pushLargeThenDate(String column, Date value) {
		if (null != value) {
			doPushLargeThenDate(column, value);
		}
	}

	protected abstract void doPushLargeThenDateTime(String column, Date value);

	@Override
	public final void pushLargeThenDateTime(String column, Date value) {
		if (null != value) {
			doPushLargeThenDateTime(column, value);
		}
	}

	protected abstract void doPushSmallThenDate(String column, Date value);

	@Override
	public final void pushSmallThenDate(String column, Date value) {
		if (null != value) {
			doPushSmallThenDate(column, value);
		}
	}

	protected abstract void doPushSmallThenDateTime(String column, Date value);

	@Override
	public final void pushSmallThenDateTime(String column, Date value) {
		if (null != value) {
			doPushSmallThenDateTime(column, value);
		}
	}

	protected abstract void doPushBetweenDate(String column, Date start, Date end);

	@Override
	public final void pushBetweenDate(String column, Date start, Date end) {
		if (null == start && null != end) {
			doPushSmallThenDate(column, end);
		} else if (null != start && null == end) {
			doPushLargeThenDate(column, start);
		} else if (null != start && null != end) {
			doPushBetweenDate(column, start, end);
		}
	}

	protected abstract void doPushBetweenDateTime(String column, Date start, Date end);

	@Override
	public final void pushBetweenDateTime(String column, Date start, Date end) {
		if (null == start && null != end) {
			doPushSmallThenDateTime(column, end);
		} else if (null != start && null == end) {
			doPushLargeThenDateTime(column, start);
		} else if (null != start && null != end) {
			doPushBetweenDateTime(column, start, end);
		}
	}

	@Override
	public void pushArgument(String column, ConditionType condition, Object arg) {
		final StringBuilder sql = new StringBuilder();
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

}

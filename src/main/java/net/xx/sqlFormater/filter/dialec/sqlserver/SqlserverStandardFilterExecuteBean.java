package net.xx.sqlFormater.filter.dialec.sqlserver;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.sqlserver.SqlserverDatabaseBean;
import net.xx.sqlFormater.filter.dialec.AbsStandardFilterExecute;
import net.xx.sqlFormater.statement.StandardStatement;

public final class SqlserverStandardFilterExecuteBean extends AbsStandardFilterExecute {

	@Override
	public void pretreatment() {}
	
	private StandardStatement mStandardStatement;
	
	@Override
	public StandardStatement getStandardStatement() {
		return mStandardStatement;
	}
	
	@Override
	public void setStandardStatement(StandardStatement standardStatement) {
		mStandardStatement = standardStatement;
	}

	@Override
	protected void doPushEqualDate(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATE);
		pushEqual(column, formater.format(value) + " 00:00:00.000");
	}

	@Override
	protected void doPushEqualDateTime(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATETIME);
		pushEqual(column, formater.format(value) + ".000");
	}

	@Override
	protected void doPushLargeThenDate(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATE);
		pushLargeThen(column, formater.format(value) + " 00:00:00.000");
	}

	@Override
	protected void doPushLargeThenDateTime(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATETIME);
		pushLargeThen(column, formater.format(value) + ".000");
	}

	@Override
	protected void doPushSmallThenDate(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATE);
		pushSmallThen(column, formater.format(value) + " 23:59:59.999");
	}

	@Override
	protected void doPushSmallThenDateTime(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATETIME);
		pushSmallThen(column, formater.format(value) + ".999");
	}

	@Override
	protected void doPushBetweenDate(String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATE);
		pushBetween(column, formater.format(start) + " 00:00:00.000", formater.format(end) + " 23:59:59.999");
	}

	@Override
	protected void doPushBetweenDateTime(String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATETIME);
		pushBetween(column, formater.format(start) + ".000", formater.format(end) + ".999");
	}

	private void pushEqual(String column, String value) {
		pushCondition(column, "= cast(? as datetime)");
		pushRawArg(value);
	}

	private void pushLargeThen(String column, String value) {
		pushCondition(column, ">= cast(? as datetime)");
		pushRawArg(value);
	}

	private void pushSmallThen(String column, String value) {
		pushCondition(column, "<= cast(? as datetime)");
		pushRawArg(value);
	}

	private void pushBetween(String column, String start, String end) {
		pushCondition(column, "between cast(? as datetime) and cast(? as datetime)");
		pushRawArg(start);
		pushRawArg(end);
	}

}

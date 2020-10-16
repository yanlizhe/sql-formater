package net.xx.sqlFormater.filter.dialec.oracle;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.oracle.OracleDatabaseBean;
import net.xx.sqlFormater.filter.dialec.AbsStandardFilterReadable;
import net.xx.sqlFormater.statement.StandardStatement;

public final class OracleStandardFilterReadableBean extends AbsStandardFilterReadable {

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
	protected void doPushEqualDate(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushEqual(table, column, formater.format(value), OracleDatabaseBean.FORMAT_DATE);
	}

	@Override
	protected void doPushEqualDateTime(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushEqual(table, column, formater.format(value), OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushLargeThenDate(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushLargeThen(table, column, formater.format(value) + "000000", OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushLargeThenDateAndNull(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushLargeThenAndNull(table, column, formater.format(value) + "000000", OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushLargeThenDateTime(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushLargeThen(table, column, formater.format(value), OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushLargeThenDateTimeAndNull(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushLargeThenAndNull(table, column, formater.format(value), OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushSmallThenDate(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushSmallThen(table, column, formater.format(value) + "235959", OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushSmallThenDateAndNull(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushSmallThenAndNull(table, column, formater.format(value) + "235959", OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushSmallThenDateTime(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushSmallThen(table, column, formater.format(value), OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushSmallThenDateTimeAndNull(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushSmallThenAndNull(table, column, formater.format(value), OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushBetweenDate(String table, String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushBetween(table, column, formater.format(start) + "000000", formater.format(end) + "235959", OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushBetweenDateTime(String table, String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushBetween(table, column, formater.format(start), formater.format(end), OracleDatabaseBean.FORMAT_DATETIME);
	}

	private void pushEqual(String table, String column, String value, String former) {
		pushCondition(table, column, "= to_date(?, ?)");
		pushRawArg(value);
		pushRawArg(former);
	}

	private void pushLargeThen(String table, String column, String value, String former) {
		pushCondition(table, column, ">= to_date(?, ?)");
		pushRawArg(value);
		pushRawArg(former);
	}

	private void pushLargeThenAndNull(String table, String column, String value, String former) {
		final StringBuilder sql = new StringBuilder();
		sql.append("(");
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" is null or ");
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" >= to_date(?, ?))");
		pushRawCondition(sql.toString());
		pushRawArg(value);
		pushRawArg(former);
	}

	private void pushSmallThen(String table, String column, String value, String former) {
		pushCondition(table, column, "<= to_date(?, ?)");
		pushRawArg(value);
		pushRawArg(former);
	}

	private void pushSmallThenAndNull(String table, String column, String value, String former) {
		final StringBuilder sql = new StringBuilder();
		sql.append("(");
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" is null or ");
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" <= to_date(?, ?))");
		pushRawCondition(sql.toString());
		pushRawArg(value);
		pushRawArg(former);
	}

	private void pushBetween(String table, String column, String start, String end, String former) {
		pushCondition(table, column, "between to_date(?, ?) and to_date(?, ?)");
		pushRawArg(start);
		pushRawArg(former);
		pushRawArg(end);
		pushRawArg(former);
	}

}

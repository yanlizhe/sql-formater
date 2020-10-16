package net.xx.sqlFormater.filter.dialec.oracle;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.oracle.OracleDatabaseBean;
import net.xx.sqlFormater.filter.dialec.AbsStandardFilterExecute;
import net.xx.sqlFormater.statement.StandardStatement;

public final class OracleStandardFilterExecuteBean extends AbsStandardFilterExecute {

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
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushEqual(column, formater.format(value), OracleDatabaseBean.FORMAT_DATE);
	}

	@Override
	protected void doPushEqualDateTime(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushEqual(column, formater.format(value), OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushLargeThenDate(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushLargeThen(column, formater.format(value) + "000000", OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushLargeThenDateTime(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushLargeThen(column, formater.format(value), OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushSmallThenDate(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushSmallThen(column, formater.format(value) + "235959", OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushSmallThenDateTime(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushSmallThen(column, formater.format(value), OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushBetweenDate(String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
		pushBetween(column, formater.format(start) + "000000", formater.format(end) + "235959", OracleDatabaseBean.FORMAT_DATETIME);
	}

	@Override
	protected void doPushBetweenDateTime(String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
		pushBetween(column, formater.format(start), formater.format(end), OracleDatabaseBean.FORMAT_DATETIME);
	}

	private void pushEqual(String column, String value, String former) {
		pushCondition(column, "= to_date(?, ?)");
		pushRawArg(value);
		pushRawArg(former);
	}

	private void pushLargeThen(String column, String value, String former) {
		pushCondition(column, ">= to_date(?, ?)");
		pushRawArg(value);
		pushRawArg(former);
	}

	private void pushSmallThen(String column, String value, String former) {
		pushCondition(column, "<= to_date(?, ?)");
		pushRawArg(value);
		pushRawArg(former);
	}

	private void pushBetween(String column, String start, String end, String former) {
		pushCondition(column, "between to_date(?, ?) and to_date(?, ?)");
		pushRawArg(start);
		pushRawArg(former);
		pushRawArg(end);
		pushRawArg(former);
	}

}

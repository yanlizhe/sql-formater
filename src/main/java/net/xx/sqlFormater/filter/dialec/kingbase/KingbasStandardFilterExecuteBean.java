package net.xx.sqlFormater.filter.dialec.kingbase;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.kingbase.KingbaseDatabaseBean;
import net.xx.sqlFormater.filter.dialec.AbsStandardFilterExecute;
import net.xx.sqlFormater.statement.StandardStatement;

public final class KingbasStandardFilterExecuteBean extends AbsStandardFilterExecute {

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
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushEqual(column, formater.format(value));
	}

	@Override
	protected void doPushEqualDateTime(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushEqual(column, formater.format(value));
	}

	@Override
	protected void doPushLargeThenDate(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushLargeThen(column, formater.format(value) + " 00:00:00");
	}

	@Override
	protected void doPushLargeThenDateTime(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushLargeThen(column, formater.format(value));
	}

	@Override
	protected void doPushSmallThenDate(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushSmallThen(column, formater.format(value) + " 23:59:59");
	}

	@Override
	protected void doPushSmallThenDateTime(String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushSmallThen(column, formater.format(value));
	}

	@Override
	protected void doPushBetweenDate(String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushBetween(column, formater.format(start) + " 00:00:00", formater.format(end) + " 23:59:59");
	}

	@Override
	protected void doPushBetweenDateTime(String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushBetween(column, formater.format(start), formater.format(end));
	}

	private void pushEqual(String column, String value) {
		pushCondition(column, "= ?");
		pushRawArg(value);
	}

	private void pushLargeThen(String column, String value) {
		pushCondition(column, ">= ?");
		pushRawArg(value);
	}

	private void pushSmallThen(String column, String value) {
		pushCondition(column, "<= ?");
		pushRawArg(value);
	}

	private void pushBetween(String column, String start, String end) {
		pushCondition(column, "between ? and ?)");
		pushRawArg(start);
		pushRawArg(end);
	}

}

package net.xx.sqlFormater.statement.dialec;

import net.xx.sqlFormater.statement.BaseStatement;

abstract class AbsStatement implements BaseStatement {
	
	private String mRawFrom;

	@Override
	public final String getOpenQuote() {
		return getGeneralFormater().getOpenQuote();
	}

	@Override
	public final String getCloseQuote() {
		return getGeneralFormater().getCloseQuote();
	}

	@Override
	public final String quoted(String text) {
		return getGeneralFormater().quoted(text);
	}

	@Override
	public final String quoted(String table, String column) {
		return getGeneralFormater().quoted(table, column);
	}

	public void setBaseFrom(String sql) {
		mRawFrom = sql;
	}
	
	public String getBaseFrom() {
		return mRawFrom;
	}

}

package net.xx.sqlFormater.selector.dialec;

import net.xx.sqlFormater.statement.StandardStatementRead;

public final class StandardSelectorBean extends AbsStandardSelector {

	@Override
	public void pretreatment() {}
	
	private StandardStatementRead mStandardStatementRead;
	
	@Override
	public StandardStatementRead getStandardStatementRead() {
		return mStandardStatementRead;
	}
	
	@Override
	public void setStandardStatementRead(StandardStatementRead standardStatementRead) {
		mStandardStatementRead = standardStatementRead;
	}

}

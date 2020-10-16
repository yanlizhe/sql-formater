package net.xx.sqlFormater.selector.dialec;

import net.xx.sqlFormater.statement.GeneralStatementRead;

public final class GeneralSelectorBean extends AbsGeneralSelector {

	@Override
	public void pretreatment() {}

	private GeneralStatementRead mGeneralStatementRead;

	@Override
	public GeneralStatementRead getGeneralStatementRead() {
		return mGeneralStatementRead;
	}

	@Override
	public void setGeneralStatementRead(GeneralStatementRead generalStatementRead) {
		mGeneralStatementRead = generalStatementRead;
	}

}

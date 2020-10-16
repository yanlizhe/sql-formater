package net.xx.sqlFormater.filter.dialec;

import net.xx.sqlFormater.statement.GeneralStatement;

public final class GeneralFilterBean extends AbsGeneralFilter {

	@Override
	public void pretreatment() {}

	private GeneralStatement mGeneralStatement;
	
	@Override
	public GeneralStatement getGeneralStatement() {
		return mGeneralStatement;
	}
	
	@Override
	public void setGeneralStatement(GeneralStatement generalStatement) {
		mGeneralStatement = generalStatement;
	}

}

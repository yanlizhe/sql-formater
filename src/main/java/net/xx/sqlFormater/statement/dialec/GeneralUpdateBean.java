package net.xx.sqlFormater.statement.dialec;

import net.xx.sqlFormater.filter.GeneralFilterExecute;

public final class GeneralUpdateBean extends AbsGeneralUpdate {
	
	public GeneralUpdateBean(GeneralFilterExecute filter) {
		super(filter);
	}

	public GeneralUpdateBean(String filter, String formater) {
		super(filter, formater);
	}

	@Override
	public void pretreatment() {}
	
	private GeneralFilterExecute mGeneralFilterExecute;
	
	@Override
	public GeneralFilterExecute getGeneralFilterExecute() {
		return mGeneralFilterExecute;
	}
	
	@Override
	public void setGeneralFilterExecute(GeneralFilterExecute generalFilterExecute) {
		mGeneralFilterExecute = generalFilterExecute;
	}

}

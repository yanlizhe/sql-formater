package net.xx.sqlFormater.statement.dialec;

import net.xx.sqlFormater.filter.GeneralFilterExecute;

public final class GeneralDeleteBean extends AbsGeneralDelete {
	
	public GeneralDeleteBean(GeneralFilterExecute filter) {
		super(filter);
	}

	public GeneralDeleteBean(String filter, String formater) {
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

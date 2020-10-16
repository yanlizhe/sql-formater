package net.xx.sqlFormater.statement.dialec;

import net.xx.sqlFormater.filter.StandardFilterExecute;

public final class StandardDeleteBean extends AbsStandardDelete {

	public StandardDeleteBean(StandardFilterExecute filter) {
		super(filter);
	}

	public StandardDeleteBean(String filter, String formater) {
		super(filter, formater);
	}

	@Override
	public void pretreatment() {}
	
	private StandardFilterExecute mStandardFilterExecute;
	
	@Override
	public StandardFilterExecute getStandardFilterExecute() {
		return mStandardFilterExecute;
	}
	
	@Override
	public void setStandardFilterExecute(StandardFilterExecute standardFilterExecute) {
		mStandardFilterExecute = standardFilterExecute;
	}

}

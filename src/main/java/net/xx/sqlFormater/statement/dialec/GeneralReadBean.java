package net.xx.sqlFormater.statement.dialec;

import net.xx.sqlFormater.filter.GeneralFilterReadable;
import net.xx.sqlFormater.selector.GeneralSelector;

public final class GeneralReadBean extends AbsGeneralRead {
	
	public GeneralReadBean(GeneralSelector selector, GeneralFilterReadable filter) {
		super(selector, filter);
	}

	public GeneralReadBean(String selector, String filter, String formater) {
		super(selector, filter, formater);
	}
	
	private GeneralSelector mGeneralSelector;
	
	@Override
	public GeneralSelector getGeneralSelector() {
		return mGeneralSelector;
	}
	
	@Override
	public void setGeneralSelector(GeneralSelector generalSelector) {
		mGeneralSelector = generalSelector;
	}
	
	private GeneralFilterReadable mGeneralFilterReadable;
	
	@Override
	public GeneralFilterReadable getGeneralFilterReadable() {
		return mGeneralFilterReadable;
	}
	
	@Override
	public void setGeneralFilterReadable(GeneralFilterReadable generalFilterReadable) {
		mGeneralFilterReadable = generalFilterReadable;
	}
	
	@Override
	public void pretreatment() {}

}

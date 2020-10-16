package net.xx.sqlFormater.statement.dialec;

import net.xx.sqlFormater.filter.StandardFilterReadable;
import net.xx.sqlFormater.selector.StandardSelector;

public final class StandardReadBean extends AbsStandardRead {

	public StandardReadBean(StandardSelector selector, StandardFilterReadable filter) {
		super(selector, filter);
	}

	public StandardReadBean(String selector, String filter, String formater) {
		super(selector, filter, formater);
	}

	@Override
	public void pretreatment() {}
	
	private StandardSelector mStandardSelector;
	
	@Override
	public StandardSelector getStandardSelector() {
		return mStandardSelector;
	}
	
	@Override
	public void setStandardSelector(StandardSelector standardSelector) {
		mStandardSelector = standardSelector;
	}
	
	private StandardFilterReadable mStandardFilterReadable;
	
	@Override
	public StandardFilterReadable getStandardFilterReadable() {
		return mStandardFilterReadable;
	}
	
	@Override
	public void setStandardFilterReadable(StandardFilterReadable standardFilterReadable) {
		mStandardFilterReadable = standardFilterReadable;
	}

}

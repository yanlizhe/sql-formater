package net.xx.sqlFormater.selector.bean;

import net.xx.sqlFormater.selector.StandardSelectorWrapper;

public final class StandardCountSelectorReadBean extends StandardSelectorWrapper {

	@Override
	public void pretreatment() {
		super.pretreatment();
		pushOperationSelection("count(1)", "total");
	}

}

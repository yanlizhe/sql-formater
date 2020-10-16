package net.xx.sqlFormater.filter;

import net.xx.sqlFormater.common.SqlFilter;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.selector.InnerBaseSelector;
import net.xx.sqlFormater.statement.BaseJoin;
import net.xx.sqlFormater.statement.BaseMain;
import net.xx.sqlFormater.statement.BaseStatementRead;

public interface BaseFilterReadable extends SqlFilter, PackagedBaseFilter, BaseMain, BaseJoin, InnerBaseSelector, InnerBaseCondition, InnerGeneralFormater {
	
	public BaseStatementRead getBaseStatementReadable();
	
	public void setBaseStatementReadable(BaseStatementRead baseStatementReadable);

}

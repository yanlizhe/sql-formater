package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.common.SqlStatementReadable;
import net.xx.sqlFormater.filter.BaseFilterReadable;
import net.xx.sqlFormater.filter.InnerBaseCondition;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.selector.BaseSelector;
import net.xx.sqlFormater.selector.InnerBaseSelector;

public interface BaseStatementRead extends SqlStatementReadable, BaseStatement, BaseJoin, InnerBaseSelector, InnerBaseCondition {
	
	public GeneralFormaterRead getGeneralFormaterRead();
	
	public void setGeneralFormaterRead(GeneralFormaterRead generalFormaterRead);
	
	public BaseSelector getBaseSelector();
	
	public void setBaseSelector(BaseSelector baseSelector);
	
	public BaseFilterReadable getBaseFilterReadable();
	
	public void setBaseFilterReadable(BaseFilterReadable baseFilterReadable);

}

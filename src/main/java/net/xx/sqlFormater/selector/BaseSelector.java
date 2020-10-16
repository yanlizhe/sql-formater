package net.xx.sqlFormater.selector;

import net.xx.sqlFormater.common.SqlSelector;
import net.xx.sqlFormater.filter.InnerBaseCondition;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.BaseJoin;
import net.xx.sqlFormater.statement.BaseMain;
import net.xx.sqlFormater.statement.BaseStatementRead;

public interface BaseSelector extends SqlSelector, InnerGeneralFormater, BaseMain, BaseJoin, InnerBaseSelector, InnerBaseCondition {
	
	public BaseStatementRead getBaseStatementRead();
	
	public void setBaseStatementRead(BaseStatementRead baseStatementRead);

}

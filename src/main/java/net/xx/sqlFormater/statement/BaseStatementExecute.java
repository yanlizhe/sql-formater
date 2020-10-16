package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.common.SqlStatementExecute;
import net.xx.sqlFormater.filter.BaseFilterExecute;
import net.xx.sqlFormater.filter.InnerBaseCondition;

public interface BaseStatementExecute extends SqlStatementExecute, BaseStatement, InnerBaseCondition {
	
	public BaseFilterExecute getBaseFilterExecute();
	
	public void setBaseFilterExecute(BaseFilterExecute baseFilterExecute);

}

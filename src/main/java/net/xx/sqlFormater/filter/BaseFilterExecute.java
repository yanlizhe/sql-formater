package net.xx.sqlFormater.filter;

import net.xx.sqlFormater.common.SqlFilter;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.BaseStatementExecute;

public interface BaseFilterExecute extends SqlFilter, PackagedBaseFilter, InnerBaseCondition, InnerGeneralFormater {
	
	public BaseStatementExecute getStatementExecute();
	
	public void setStatementExecute(BaseStatementExecute baseStatementExecute);

}

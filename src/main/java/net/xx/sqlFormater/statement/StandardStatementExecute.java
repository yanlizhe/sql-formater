package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.filter.InnerStandardConditionExecute;
import net.xx.sqlFormater.filter.StandardFilterExecute;

public interface StandardStatementExecute extends StandardStatement, InnerStandardMain, InnerStandardValue, InnerStandardConditionExecute {
	
	public StandardFilterExecute getStandardFilterExecute();
	
	public void setStandardFilterExecute(StandardFilterExecute standardFilterExecute);

}

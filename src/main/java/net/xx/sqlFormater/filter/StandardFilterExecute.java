package net.xx.sqlFormater.filter;

import net.xx.sqlFormater.SqlStandardFilterExecute;
import net.xx.sqlFormater.statement.InnerGeneralMainExecute;
import net.xx.sqlFormater.statement.StandardStatementExecute;

public interface StandardFilterExecute extends PackagedStandardFilter, SqlStandardFilterExecute, 
		InnerGeneralMainExecute, InnerGeneralCondition {
	
	public StandardStatementExecute getStandardStatementExecute();
	
	public void setStandardStatementExecute(StandardStatementExecute standardStatementExecute);

}

package net.xx.sqlFormater.filter;

import net.xx.sqlFormater.SqlGeneralFilterExecute;
import net.xx.sqlFormater.statement.GeneralStatementExecute;

public interface GeneralFilterExecute extends PackagedGeneralFilter, SqlGeneralFilterExecute {
	
	public GeneralStatementExecute getGeneralStatementExecute();
	
	public void setGeneralStatementExecute(GeneralStatementExecute generalStatementExecute);

}

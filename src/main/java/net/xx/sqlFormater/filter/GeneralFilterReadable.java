package net.xx.sqlFormater.filter;

import net.xx.sqlFormater.SqlGeneralFilterReadable;
import net.xx.sqlFormater.statement.GeneralStatementRead;

public interface GeneralFilterReadable extends PackagedGeneralFilter, SqlGeneralFilterReadable {
	
	public GeneralStatementRead getGeneralStatementRead();
	
	public void setGeneralStatementRead(GeneralStatementRead generalStatementRead);

}

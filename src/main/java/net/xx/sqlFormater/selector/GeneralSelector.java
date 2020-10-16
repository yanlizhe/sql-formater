package net.xx.sqlFormater.selector;

import net.xx.sqlFormater.SqlGeneralSelector;
import net.xx.sqlFormater.statement.GeneralStatementRead;

public interface GeneralSelector extends SqlGeneralSelector {
	
	public GeneralStatementRead getGeneralStatementRead();
	
	public void setGeneralStatementRead(GeneralStatementRead generalStatementRead);

}

package net.xx.sqlFormater.selector;

import net.xx.sqlFormater.SqlStandardSelector;
import net.xx.sqlFormater.filter.InnerGeneralCondition;
import net.xx.sqlFormater.statement.InnerGeneralJoin;
import net.xx.sqlFormater.statement.InnerGeneralMainReadable;
import net.xx.sqlFormater.statement.StandardStatementRead;

public interface StandardSelector extends SqlStandardSelector, 
		InnerGeneralMainReadable, InnerGeneralJoin, InnerGeneralSelector, InnerGeneralCondition {
	
	public StandardStatementRead getStandardStatementRead();
	
	public void setStandardStatementRead(StandardStatementRead standardStatementRead);

}

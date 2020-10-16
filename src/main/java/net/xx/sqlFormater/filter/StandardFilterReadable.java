package net.xx.sqlFormater.filter;

import net.xx.sqlFormater.SqlStandardFilterReadable;
import net.xx.sqlFormater.selector.InnerGeneralSelector;
import net.xx.sqlFormater.statement.InnerGeneralJoin;
import net.xx.sqlFormater.statement.InnerGeneralMainReadable;
import net.xx.sqlFormater.statement.StandardStatementRead;

public interface StandardFilterReadable extends PackagedStandardFilter, SqlStandardFilterReadable, 
			InnerGeneralMainReadable, InnerGeneralJoin, InnerGeneralSelector, InnerGeneralCondition {
	
	public StandardStatementRead getStandardStatementRead();
	
	public void setStandardStatementRead(StandardStatementRead standardStatementRead);

}

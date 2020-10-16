package net.xx.sqlFormater.filter;

import net.xx.sqlFormater.statement.BaseStatement;

interface PackagedBaseFilter {
	
	public BaseStatement getBaseStatement();
	
	public void setBaseStatement(BaseStatement baseStatement);

}

package net.xx.sqlFormater.filter;

import net.xx.sqlFormater.statement.GeneralStatement;

interface PackagedGeneralFilter {
	
	public GeneralStatement getGeneralStatement();
	
	public void setGeneralStatement(GeneralStatement generalStatement);

}

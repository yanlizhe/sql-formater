package net.xx.sqlFormater.filter;

import net.xx.sqlFormater.statement.StandardStatement;

interface PackagedStandardFilter {
	
	public StandardStatement getStandardStatement();
	
	public void setStandardStatement(StandardStatement standardStatement);

}

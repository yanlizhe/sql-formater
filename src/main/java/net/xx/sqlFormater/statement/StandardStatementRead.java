package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.SqlStandardRead;
import net.xx.sqlFormater.filter.InnerGeneralCondition;
import net.xx.sqlFormater.filter.InnerStandardConditionReadable;
import net.xx.sqlFormater.filter.StandardFilterReadable;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.selector.InnerGeneralSelector;
import net.xx.sqlFormater.selector.InnerStandardSelector;
import net.xx.sqlFormater.selector.StandardSelector;

public interface StandardStatementRead extends StandardStatement, SqlStandardRead, InnerStandardMain, 
		InnerStandardSelector, InnerStandardJoin, InnerStandardConditionReadable, InnerGeneralFormater, 
		InnerGeneralMainReadable, InnerGeneralJoin, InnerGeneralSelector, InnerGeneralCondition {
	
	public StandardSelector getStandardSelector();
	
	public void setStandardSelector(StandardSelector standardSelector);
	
	public StandardFilterReadable getStandardFilterReadable();
	
	public void setStandardFilterReadable(StandardFilterReadable standardFilterReadable);
	
	public GeneralFormaterRead getGeneralFormaterRead();
	
	public void setGeneralFormaterRead(GeneralFormaterRead generalFormaterRead);

}

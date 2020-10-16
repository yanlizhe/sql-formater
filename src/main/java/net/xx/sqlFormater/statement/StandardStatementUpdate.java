package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.SqlStandardUpdate;
import net.xx.sqlFormater.formater.GeneralFormaterUpdate;

public interface StandardStatementUpdate extends StandardStatementExecute, SqlStandardUpdate {
	
	public GeneralFormaterUpdate getGeneralFormaterUpdate();
	
	public void setGeneralFormaterUpdate(GeneralFormaterUpdate generalFormaterUpdate);

}

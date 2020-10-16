package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.SqlStandardDelete;
import net.xx.sqlFormater.formater.GeneralFormaterDelete;

public interface StandardStatementDelete extends StandardStatementExecute, SqlStandardDelete {
	
	public GeneralFormaterDelete getGeneralFormaterDelete();
	
	public void setGeneralFormaterDelete(GeneralFormaterDelete generalFormaterDelete);

}

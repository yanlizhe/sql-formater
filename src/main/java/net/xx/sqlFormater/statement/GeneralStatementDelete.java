package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.SqlGeneralDelete;
import net.xx.sqlFormater.formater.GeneralFormaterDelete;

public interface GeneralStatementDelete extends SqlGeneralDelete, GeneralStatementExecute {
	
	public GeneralFormaterDelete getGeneralFormaterDelete();
	
	public void setGeneralFormaterDelete(GeneralFormaterDelete generalFormaterDelete);

}

package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.formater.GeneralFormaterDelete;

public interface BaseStatementDelete extends BaseStatementExecute {
	
	public GeneralFormaterDelete getGeneralFormaterDelete();
	
	public void setGeneralFormaterDelete(GeneralFormaterDelete generalFormaterDelete);

}

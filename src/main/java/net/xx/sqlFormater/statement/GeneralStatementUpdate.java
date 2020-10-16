package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.SqlGeneralUpdate;
import net.xx.sqlFormater.formater.GeneralFormaterUpdate;

public interface GeneralStatementUpdate extends SqlGeneralUpdate, GeneralStatementExecute {
	
	public GeneralFormaterUpdate getGeneralFormaterUpdate();
	
	public void setGeneralFormaterUpdate(GeneralFormaterUpdate generalFormaterUpdate);

}

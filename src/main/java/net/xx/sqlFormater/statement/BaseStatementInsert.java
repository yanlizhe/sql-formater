package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.common.SqlStatementExecute;
import net.xx.sqlFormater.formater.GeneralFormaterInsert;

public interface BaseStatementInsert extends SqlStatementExecute, BaseStatement {
	
	public GeneralFormaterInsert getGeneralFormaterInsert();
	
	public void setGeneralFormaterInsert(GeneralFormaterInsert generalFormaterInsert);

}

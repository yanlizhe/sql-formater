package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.SqlGeneralInsert;
import net.xx.sqlFormater.formater.GeneralFormaterInsert;

public interface GeneralStatementInsert extends GeneralStatement, SqlGeneralInsert {
	
	public GeneralFormaterInsert getGeneralFormaterInsert();
	
	public void setGeneralFormaterInsert(GeneralFormaterInsert generalFormaterInsert);

}

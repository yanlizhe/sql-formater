package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.SqlStandardInsert;
import net.xx.sqlFormater.formater.GeneralFormaterInsert;

public interface StandardStatementInsert extends StandardStatement, SqlStandardInsert {
	
	public GeneralFormaterInsert getGeneralFormaterInsert();
	
	public void setGeneralFormaterInsert(GeneralFormaterInsert generalFormaterInsert);

}

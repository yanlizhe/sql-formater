package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.filter.GeneralFilterExecute;
import net.xx.sqlFormater.filter.InnerGeneralCondition;

public interface GeneralStatementExecute extends GeneralStatement, InnerGeneralMainExecute, InnerGeneralCondition {
	
	public GeneralFilterExecute getGeneralFilterExecute();
	
	public void setGeneralFilterExecute(GeneralFilterExecute generalFilterExecute);

}

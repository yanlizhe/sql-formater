package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlStatementExecute;
import net.xx.sqlFormater.filter.InnerGeneralCondition;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.InnerGeneralMainExecute;

/**
* 基本的SQL更新语句
* @author Liz
*/
public interface SqlGeneralUpdate extends SqlStatementExecute, InnerGeneralMainExecute, InnerGeneralCondition, InnerGeneralFormater {
	
	public void pushRawSet(String sql);
	
	public void pushRawValue(Object value);

}

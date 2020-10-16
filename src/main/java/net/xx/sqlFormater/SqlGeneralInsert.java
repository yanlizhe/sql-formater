package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlStatementExecute;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.InnerGeneralMainExecute;

/**
 * 基本的SQL插入语句
 * @author Liz
 */
public interface SqlGeneralInsert extends SqlStatementExecute, InnerGeneralMainExecute, InnerGeneralFormater {
	
	public void pushRawColumn(String sql);
	
	public void pushRawValue(String sql);
	
	public void pushRawArg(Object arg);

}

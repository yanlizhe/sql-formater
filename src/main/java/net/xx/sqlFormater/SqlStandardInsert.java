package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlStatementExecute;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.InnerStandardMain;
import net.xx.sqlFormater.statement.InnerStandardValue;

/**
 * 标准的SQL插入语句
 * @author Liz
 */
public interface SqlStandardInsert extends SqlStatementExecute, InnerStandardMain, InnerStandardValue, InnerGeneralFormater {

}

package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlStatementExecute;
import net.xx.sqlFormater.filter.InnerStandardConditionExecute;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.InnerStandardMain;

/**
 * 标准的SQL删除语句
 * @author Liz
 */
public interface SqlStandardDelete extends SqlStatementExecute, InnerStandardMain, InnerStandardConditionExecute, InnerGeneralFormater {

}

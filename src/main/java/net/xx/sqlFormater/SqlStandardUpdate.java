package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlStatementExecute;
import net.xx.sqlFormater.filter.InnerStandardConditionExecute;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.InnerStandardMain;
import net.xx.sqlFormater.statement.InnerStandardValue;

/**
 * 标准的SQL更新语句
 * @author Liz
 */
public interface SqlStandardUpdate extends SqlStatementExecute, InnerStandardMain, InnerStandardValue, InnerStandardConditionExecute, InnerGeneralFormater {

}

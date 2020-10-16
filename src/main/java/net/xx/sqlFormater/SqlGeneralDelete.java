package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlStatementExecute;
import net.xx.sqlFormater.filter.InnerGeneralCondition;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.InnerGeneralMainExecute;

/**
 * 基本的SQL删除语句
 * @author Liz
 */
public interface SqlGeneralDelete extends SqlStatementExecute, InnerGeneralMainExecute, InnerGeneralCondition, InnerGeneralFormater {

}

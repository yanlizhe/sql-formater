package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlFilter;
import net.xx.sqlFormater.filter.InnerGeneralCondition;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.InnerGeneralMainExecute;

/**
 * 基本的SQL查询条件（执行语句用）
 * @author Liz
 */
public interface SqlGeneralFilterExecute extends SqlFilter, InnerGeneralMainExecute, InnerGeneralCondition, InnerGeneralFormater {

}

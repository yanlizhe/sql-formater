package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlFilter;
import net.xx.sqlFormater.filter.InnerStandardConditionExecute;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.statement.InnerStandardMain;
import net.xx.sqlFormater.statement.InnerStandardValue;

/**
 * 标准的SQL查询条件（执行语句用）
 * @author Liz
 */
public interface SqlStandardFilterExecute extends SqlFilter, InnerStandardMain, InnerStandardValue, InnerStandardConditionExecute, InnerGeneralFormater {

}

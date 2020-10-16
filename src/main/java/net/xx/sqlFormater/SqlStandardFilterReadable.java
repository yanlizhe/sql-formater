package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlFilter;
import net.xx.sqlFormater.filter.InnerStandardConditionReadable;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.selector.InnerStandardSelector;
import net.xx.sqlFormater.statement.InnerStandardJoin;
import net.xx.sqlFormater.statement.InnerStandardMain;

/**
 * 标准的SQL查询条件（查询语句用）
 * @author Liz
 */
public interface SqlStandardFilterReadable extends SqlFilter, InnerStandardMain, InnerStandardSelector, 
		InnerStandardJoin, InnerStandardConditionReadable, InnerGeneralFormater {

}

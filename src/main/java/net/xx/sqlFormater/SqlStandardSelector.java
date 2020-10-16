package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlSelector;
import net.xx.sqlFormater.filter.InnerStandardConditionReadable;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.selector.InnerStandardSelector;
import net.xx.sqlFormater.statement.InnerStandardJoin;
import net.xx.sqlFormater.statement.InnerStandardMainReadable;

/**
 * 标准的SQL字段选择及排序
 * @author Liz
 */
public interface SqlStandardSelector extends SqlSelector, InnerStandardMainReadable, InnerStandardSelector, 
		InnerStandardJoin, InnerStandardConditionReadable, InnerGeneralFormater {

}

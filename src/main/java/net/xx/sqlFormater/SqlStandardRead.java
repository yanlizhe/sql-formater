package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlStatementReadable;
import net.xx.sqlFormater.filter.InnerStandardConditionReadable;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.selector.InnerStandardSelector;
import net.xx.sqlFormater.statement.InnerStandardJoin;
import net.xx.sqlFormater.statement.InnerStandardMainReadable;

/**
 * 标准的SQL查询语句
 * @author Liz
 */
public interface SqlStandardRead extends SqlStatementReadable, InnerStandardMainReadable, InnerStandardSelector, 
		InnerStandardJoin, InnerStandardConditionReadable, InnerGeneralFormater {

}

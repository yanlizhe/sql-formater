package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlFilter;
import net.xx.sqlFormater.filter.InnerGeneralCondition;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.selector.InnerGeneralSelector;
import net.xx.sqlFormater.statement.InnerGeneralJoin;
import net.xx.sqlFormater.statement.InnerGeneralMainReadable;

/**
 * 基本的SQL查询条件（查询语句用）
 * @author Liz
 */
public interface SqlGeneralFilterReadable extends SqlFilter, InnerGeneralMainReadable, InnerGeneralJoin, InnerGeneralSelector, InnerGeneralCondition, InnerGeneralFormater {

}

package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlStatementReadable;
import net.xx.sqlFormater.filter.InnerGeneralCondition;
import net.xx.sqlFormater.selector.InnerGeneralSelector;
import net.xx.sqlFormater.statement.InnerGeneralJoin;
import net.xx.sqlFormater.statement.InnerGeneralMainReadable;

/**
 * 基本的SQL查询语句
 * @author Liz
 */
public interface SqlGeneralRead extends SqlStatementReadable, InnerGeneralMainReadable, InnerGeneralJoin, InnerGeneralSelector, InnerGeneralCondition {

}

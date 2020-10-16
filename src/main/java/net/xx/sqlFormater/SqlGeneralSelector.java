package net.xx.sqlFormater;

import net.xx.sqlFormater.common.SqlSelector;
import net.xx.sqlFormater.filter.InnerGeneralCondition;
import net.xx.sqlFormater.formater.InnerGeneralFormater;
import net.xx.sqlFormater.selector.InnerGeneralSelector;
import net.xx.sqlFormater.statement.InnerGeneralJoin;
import net.xx.sqlFormater.statement.InnerGeneralMainReadable;

/**
 * 基本的SQL字段选择及排序
 * @author Liz
 */
public interface SqlGeneralSelector extends SqlSelector, InnerGeneralMainReadable, InnerGeneralJoin, InnerGeneralSelector, InnerGeneralCondition, InnerGeneralFormater {

}

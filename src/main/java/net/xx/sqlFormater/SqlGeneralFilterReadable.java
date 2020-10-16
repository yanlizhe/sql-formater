/*
 * Copyright (C) 2016 Lizhe Yan.
 * 
 * Author: Lizhe Yan <yanlizhe@sina.com>
 * 
 * This file is part of sql-formater.
 * 
 * sql-formater is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later 
 * version.
 * 
 * sql-formater is distributed in the hope that it will be 
 * useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
 * PURPOSE. See the GNU Lesser General Public License for more 
 * details.
 * 
 * You should have received a copy of the GNU Lesser General 
 * Public License along with sql-formater. 
 * If not, see <https://www.gnu.org/licenses/>.
 * 
 */

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

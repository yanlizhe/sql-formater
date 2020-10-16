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

package net.xx.sqlFormater.selector;

import java.util.List;

public interface InnerBaseSelector {
	
	/**
	 * 获取当前别名列表
	 * @param generated 如果没有，是否需要新建
	 * @return 内容列表
	 */
	public List<String> getBaseAlias(boolean generated);

	/**
	 * 获取当前的数据项列表
	 * @param generated 如果没有，是否需要新建
	 * @return 内容列表
	 */
	public List<String> getBaseSelection(boolean generated);

	/**
	 * 获取当前的分组列表
	 * @param generated 如果没有，是否需要新建
	 * @return 内容列表
	 */
	public List<String> getBaseGroup(boolean generated);

	/**
	 * 获取当前的排序列表
	 * @param generated 如果没有，是否需要新建
	 * @return 内容列表
	 */
	public List<String> getBaseSort(boolean generated);

}

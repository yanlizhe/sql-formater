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

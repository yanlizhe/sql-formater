package net.xx.sqlFormater.filter;

import java.util.List;

public interface InnerBaseCondition {
	
	/**
	 * 获取当前的搜索条件列表
	 * @param generated 如果没有，是否需要新建
	 * @return 内容列表
	 */
	public List<String> getBaseCondition(boolean generated);
	
	/**
	 * 获取当前的参数列表
	 * @param generated 如果没有，是否需要新建
	 * @return 内容列表
	 */
	public List<Object> getBaseArgs(boolean generated);

}

package net.xx.sqlFormater.statement;

import java.util.List;

import net.xx.sqlFormater.util.JoinStatement;

public interface BaseJoin {
	
	/**
	 * 获取当前的合并查询列表
	 * @param generated 如果没有，是否需要新建
	 * @return 内容列表
	 */
	public List<JoinStatement> getBaseJoin(boolean generated);

}

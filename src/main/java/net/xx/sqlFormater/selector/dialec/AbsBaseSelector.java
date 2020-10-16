package net.xx.sqlFormater.selector.dialec;

import java.util.LinkedList;
import java.util.List;

import net.xx.sqlFormater.selector.BaseSelector;
import net.xx.sqlFormater.util.JoinStatement;

abstract class AbsBaseSelector implements BaseSelector {

	@Override
	public final String getOpenQuote() {
		return getBaseStatementRead().getOpenQuote();
	}

	@Override
	public final String getCloseQuote() {
		return getBaseStatementRead().getCloseQuote();
	}

	@Override
	public final String quoted(String text) {
		return getBaseStatementRead().quoted(text);
	}

	@Override
	public final String quoted(String table, String column) {
		return getBaseStatementRead().quoted(table, column);
	}
	
	
	
	private LinkedList<String> mBaseAlias;
	private LinkedList<String> mBaseSelection;
	private LinkedList<String> mBaseGroup;
	private LinkedList<String> mBaseSort;

	@Override
	public List<String> getBaseAlias(boolean generated) {
		if (null == mBaseAlias && generated) {
			mBaseAlias = new LinkedList<String>();
		}
		return mBaseAlias;
	}

	@Override
	public List<String> getBaseSelection(boolean generated) {
		if (null == mBaseSelection && generated) {
			mBaseSelection = new LinkedList<String>();
		}
		return mBaseSelection;
	}

	@Override
	public void setBaseFrom(String sql) {
		getBaseStatementRead().setBaseFrom(sql);
	}

	@Override
	public String getBaseFrom() {
		return getBaseStatementRead().getBaseFrom();
	}

	@Override
	public List<JoinStatement> getBaseJoin(boolean generated) {
		return getBaseStatementRead().getBaseJoin(generated);
	}

	@Override
	public List<String> getBaseCondition(boolean generated) {
		return getBaseStatementRead().getBaseCondition(generated);
	}

	@Override
	public List<Object> getBaseArgs(boolean generated) {
		return getBaseStatementRead().getBaseArgs(generated);
	}

	@Override
	public List<String> getBaseGroup(boolean generated) {
		if (null == mBaseGroup && generated) {
			mBaseGroup = new LinkedList<String>();
		}
		return mBaseGroup;
	}

	@Override
	public List<String> getBaseSort(boolean generated) {
		if (null == mBaseSort && generated) {
			mBaseSort = new LinkedList<String>();
		}
		return mBaseSort;
	}

}

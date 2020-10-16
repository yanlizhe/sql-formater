package net.xx.sqlFormater.filter.dialec;

import java.util.LinkedList;
import java.util.List;

import net.xx.sqlFormater.filter.BaseFilterExecute;
import net.xx.sqlFormater.filter.BaseFilterReadable;
import net.xx.sqlFormater.statement.BaseStatement;
import net.xx.sqlFormater.statement.BaseStatementExecute;
import net.xx.sqlFormater.statement.BaseStatementRead;
import net.xx.sqlFormater.util.JoinStatement;

abstract class AbsBaseFilter implements BaseFilterReadable, BaseFilterExecute {

	@Override
	public final BaseStatementRead getBaseStatementReadable() {
		return (BaseStatementRead) getBaseStatement();
	}
	
	@Override
	public final void setBaseStatementReadable(BaseStatementRead baseStatementReadable) {
		setBaseStatement((BaseStatement) baseStatementReadable);
	}

	@Override
	public final BaseStatementExecute getStatementExecute() {
		return (BaseStatementExecute) getBaseStatement();
	}
	
	@Override
	public final void setStatementExecute(BaseStatementExecute baseStatementExecute) {
		setBaseStatement((BaseStatement) baseStatementExecute);
	}
	
	

	@Override
	public final String getOpenQuote() {
		return getBaseStatement().getOpenQuote();
	}

	@Override
	public final String getCloseQuote() {
		return getBaseStatement().getCloseQuote();
	}

	@Override
	public final String quoted(String text) {
		return getBaseStatement().quoted(text);
	}

	@Override
	public final String quoted(String table, String column) {
		return getBaseStatement().quoted(table, column);
	}
	
	
	
	private LinkedList<String> mBaseCondition;
	private LinkedList<Object> mBaseArgs;

	@Override
	public List<String> getBaseAlias(boolean generated) {
		return getBaseStatementReadable().getBaseAlias(generated);
	}

	@Override
	public List<String> getBaseSelection(boolean generated) {
		return getBaseStatementReadable().getBaseSelection(generated);
	}

	@Override
	public void setBaseFrom(String sql) {
		getBaseStatement().setBaseFrom(sql);
	}

	@Override
	public String getBaseFrom() {
		return getBaseStatement().getBaseFrom();
	}

	@Override
	public List<JoinStatement> getBaseJoin(boolean generated) {
		return getBaseStatementReadable().getBaseJoin(generated);
	}

	@Override
	public List<String> getBaseCondition(boolean generated) {
		if (null == mBaseCondition && generated) {
			mBaseCondition = new LinkedList<String>();
		}
		return mBaseCondition;
	}

	@Override
	public List<Object> getBaseArgs(boolean generated) {
		if (null == mBaseArgs && generated) {
			mBaseArgs = new LinkedList<Object>();
		}
		return mBaseArgs;
	}

	@Override
	public List<String> getBaseGroup(boolean generated) {
		return getBaseStatementReadable().getBaseGroup(generated);
	}

	@Override
	public List<String> getBaseSort(boolean generated) {
		return getBaseStatementReadable().getBaseSort(generated);
	}

}

package net.xx.sqlFormater.selector.dialec;

import net.xx.sqlFormater.selector.GeneralSelector;
import net.xx.sqlFormater.statement.BaseStatementRead;
import net.xx.sqlFormater.statement.GeneralStatementRead;
import net.xx.sqlFormater.statement.GeneralStatementReadWrapper;
import net.xx.sqlFormater.util.JoinStatement;

abstract class AbsGeneralSelector extends AbsBaseSelector implements GeneralSelector {

	@Override
	public final BaseStatementRead getBaseStatementRead() {
		GeneralStatementRead statement = getGeneralStatementRead();
		if (statement instanceof GeneralStatementReadWrapper) {
			statement = ((GeneralStatementReadWrapper) statement).getSource();
		}
		return (BaseStatementRead) statement;
	}
	
	@Override
	public final void setBaseStatementRead(BaseStatementRead baseStatementRead) {
		setGeneralStatementRead((GeneralStatementRead) baseStatementRead);
	}
	
	

	@Override
	public void pushRawAlias(String sql) {
		getBaseAlias(true).add(sql);
	}

	@Override
	public void pushRawSelection(String sql) {
		getBaseSelection(true).add(sql);
	}

	@Override
	public void setRawFrom(String key, String sql) {
		getGeneralStatementRead().setRawFrom(key, sql);
	}

	@Override
	public void unshiftRawJoin(String key, String sql) {
		getGeneralStatementRead().unshiftRawJoin(key, sql);
	}

	@Override
	public void pushRawJoin(String key, String sql) {
		getGeneralStatementRead().pushRawJoin(key, sql);
	}

	@Override
	public JoinStatement getRawJoin(String key) {
		return getGeneralStatementRead().getRawJoin(key);
	}

	@Override
	public void refreshRawJoin(String key, String sql) {
		getGeneralStatementRead().refreshRawJoin(key, sql);
	}

	@Override
	public void pushRawCondition(String sql) {
		getGeneralStatementRead().pushRawCondition(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getGeneralStatementRead().pushRawArg(arg);
	}

	@Override
	public void mergeRawArg(Object[] args) {
		getGeneralStatementRead().mergeRawArg(args);
	}

	@Override
	public void unshiftRawGroup(String sql) {
		getBaseGroup(true).add(0, sql);
	}

	@Override
	public void pushRawGroup(String sql) {
		getBaseGroup(true).add(sql);
	}

	@Override
	public void unshiftRawSort(String sql) {
		getBaseSort(true).add(0, sql);
	}

	@Override
	public void pushRawSort(String sql) {
		getBaseSort(true).add(sql);
	}

}

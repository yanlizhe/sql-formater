package net.xx.sqlFormater.filter.dialec;

import net.xx.sqlFormater.filter.GeneralFilterExecute;
import net.xx.sqlFormater.filter.GeneralFilterReadable;
import net.xx.sqlFormater.statement.BaseStatement;
import net.xx.sqlFormater.statement.GeneralStatement;
import net.xx.sqlFormater.statement.GeneralStatementDeleteWrapper;
import net.xx.sqlFormater.statement.GeneralStatementExecute;
import net.xx.sqlFormater.statement.GeneralStatementRead;
import net.xx.sqlFormater.statement.GeneralStatementReadWrapper;
import net.xx.sqlFormater.statement.GeneralStatementUpdateWrapper;
import net.xx.sqlFormater.util.JoinStatement;

abstract class AbsGeneralFilter extends AbsBaseFilter implements GeneralFilterReadable, GeneralFilterExecute {

	@Override
	public final GeneralStatementRead getGeneralStatementRead() {
		return (GeneralStatementRead) getGeneralStatement();
	}
	
	@Override
	public final void setGeneralStatementRead(GeneralStatementRead generalStatementRead) {
		setGeneralStatement((GeneralStatement) generalStatementRead);
	}

	@Override
	public final GeneralStatementExecute getGeneralStatementExecute() {
		return (GeneralStatementExecute) getGeneralStatement();
	}
	
	@Override
	public final void setGeneralStatementExecute(GeneralStatementExecute generalStatementExecute) {
		setGeneralStatement((GeneralStatement) generalStatementExecute);
	}

	@Override
	public final BaseStatement getBaseStatement() {
		GeneralStatement statement = getGeneralStatement();
		if (null != statement) {
			if (statement instanceof GeneralStatementReadWrapper) {
				statement = ((GeneralStatementReadWrapper) statement).getSource();
			} else if (statement instanceof GeneralStatementUpdateWrapper) {
				statement = ((GeneralStatementUpdateWrapper) statement).getSource();
			} else if (statement instanceof GeneralStatementDeleteWrapper) {
				statement = ((GeneralStatementDeleteWrapper) statement).getSource();
			}
		}
		return (BaseStatement) statement;
	}
	
	@Override
	public final void setBaseStatement(BaseStatement baseStatement) {
		setGeneralStatement((GeneralStatement) baseStatement);
	}
	
	

	@Override
	public void pushRawAlias(String sql) {
		getGeneralStatementRead().pushRawAlias(sql);
	}

	@Override
	public void pushRawSelection(String sql) {
		getGeneralStatementRead().pushRawSelection(sql);
	}

	@Override
	public void setRawFrom(String sql) {
		getGeneralStatementExecute().setRawFrom(sql);
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
		getBaseCondition(true).add(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getBaseArgs(true).add(arg);
	}

	@Override
	public void mergeRawArg(Object[] args) {
		for (int i = 0; i < args.length; i++) {
			getBaseArgs(true).add(args[i]);
		}
	}

	@Override
	public void unshiftRawGroup(String sql) {
		getGeneralStatementRead().unshiftRawGroup(sql);
	}

	@Override
	public void pushRawGroup(String sql) {
		getGeneralStatementRead().pushRawGroup(sql);
	}

	@Override
	public void unshiftRawSort(String sql) {
		getGeneralStatementRead().unshiftRawSort(sql);
	}

	@Override
	public void pushRawSort(String sql) {
		getGeneralStatementRead().pushRawSort(sql);
	}

}

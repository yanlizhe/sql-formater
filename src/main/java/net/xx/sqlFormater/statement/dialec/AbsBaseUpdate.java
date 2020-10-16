package net.xx.sqlFormater.statement.dialec;

import java.util.LinkedList;
import java.util.List;

import net.xx.sqlFormater.formater.GeneralFormater;
import net.xx.sqlFormater.formater.GeneralFormaterUpdate;
import net.xx.sqlFormater.formater.GeneralFormaterUpdateWrapper;
import net.xx.sqlFormater.statement.BaseStatementUpdate;

abstract class AbsBaseUpdate extends AbsStatement implements BaseStatementUpdate {
	
	@Override
	public final GeneralFormater getGeneralFormater() {
		GeneralFormaterUpdate formater = getGeneralFormaterUpdate();
		if (null != formater && formater instanceof GeneralFormaterUpdateWrapper) {
			formater = ((GeneralFormaterUpdateWrapper) formater).getSource();
		}
		return (GeneralFormater) formater;
	}
	
	@Override
	public final void setGeneralFormater(GeneralFormater generalFormater) {
		setGeneralFormaterUpdate((GeneralFormaterUpdate) generalFormater);
	}
	
	

	@Override
	public final String getSql() {
		return getGeneralFormaterUpdate().getSql(getBaseFrom(), getBaseSet(false), 
				getBaseFilterExecute().getBaseCondition(false));
	}

	@Override
	public final Object[] getArgs() {
		return getGeneralFormaterUpdate().getArgs(getBaseValues(false), getBaseFilterExecute().getBaseArgs(false));
	}
	
	
	
	@Override
	public final int execute() {
		return getGeneralFormater().getGeneralDatabase().getSpringJdbc().update(getSql(), getArgs());
	}
	
	
	
	private LinkedList<String> mBaseSet;
	private LinkedList<Object> mBaseValues;

	@Override
	public List<String> getBaseSet(boolean generated) {
		if (null == mBaseSet && generated) {
			mBaseSet = new LinkedList<String>();
		}
		return mBaseSet;
	}

	@Override
	public List<Object> getBaseValues(boolean generated) {
		if (null == mBaseValues && generated) {
			mBaseValues = new LinkedList<Object>();
		}
		return mBaseValues;
	}

	@Override
	public List<String> getBaseCondition(boolean generated) {
		return getBaseFilterExecute().getBaseCondition(generated);
	}

	@Override
	public List<Object> getBaseArgs(boolean generated) {
		return getBaseFilterExecute().getBaseArgs(generated);
	}

}

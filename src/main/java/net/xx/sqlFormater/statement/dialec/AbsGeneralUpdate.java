package net.xx.sqlFormater.statement.dialec;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.filter.BaseFilterExecute;
import net.xx.sqlFormater.filter.GeneralFilterExecute;
import net.xx.sqlFormater.filter.GeneralFilterExecuteWrapper;
import net.xx.sqlFormater.formater.GeneralFormaterUpdate;
import net.xx.sqlFormater.statement.GeneralStatementUpdate;

abstract class AbsGeneralUpdate extends AbsBaseUpdate implements GeneralStatementUpdate {
	
	protected AbsGeneralUpdate(GeneralFilterExecute filter) {
		if (null != filter) {
			setGeneralFilterExecute(filter);
		}
	}
	
	protected AbsGeneralUpdate(String filter, String formater) {
		if(SqlBeanFactory.hasName(filter)) {
			setGeneralFilterExecute(SqlBeanFactory.getBean(filter, GeneralFilterExecute.class));
		}
		if(SqlBeanFactory.hasName(formater)) {
			setGeneralFormaterUpdate(SqlBeanFactory.getBean(formater, GeneralFormaterUpdate.class));
		}
	}
	
	private GeneralFormaterUpdate mGeneralFormaterUpdate;

	@Override
	public GeneralFormaterUpdate getGeneralFormaterUpdate() {
		return mGeneralFormaterUpdate;
	}

	@Override
	public void setGeneralFormaterUpdate(GeneralFormaterUpdate generalFormaterUpdate) {
		mGeneralFormaterUpdate = generalFormaterUpdate;
	}

	@Override
	public final BaseFilterExecute getBaseFilterExecute() {
		GeneralFilterExecute filter = getGeneralFilterExecute();
		if (filter instanceof GeneralFilterExecuteWrapper) {
			filter = ((GeneralFilterExecuteWrapper) filter).getSource();
		}
		return (BaseFilterExecute) filter;
	}
	
	@Override
	public final void setBaseFilterExecute(BaseFilterExecute baseFilterExecute) {
		setGeneralFilterExecute((GeneralFilterExecute) baseFilterExecute);
	}
	
	
	
	@Override
	public void setRawFrom(String sql) {
		setBaseFrom(sql);
	}

	@Override
	public void pushRawSet(String sql) {
		getBaseSet(true).add(sql);
	}

	@Override
	public void pushRawValue(Object value) {
		getBaseValues(true).add(value);
	}

	@Override
	public void pushRawCondition(String sql) {
		getGeneralFilterExecute().pushRawCondition(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getGeneralFilterExecute().pushRawArg(arg);
	}

	@Override
	public void mergeRawArg(Object[] args) {
		getGeneralFilterExecute().mergeRawArg(args);
	}

}

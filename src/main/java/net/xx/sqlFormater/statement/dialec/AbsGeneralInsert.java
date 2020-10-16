package net.xx.sqlFormater.statement.dialec;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.formater.GeneralFormaterInsert;
import net.xx.sqlFormater.statement.GeneralStatementInsert;

abstract class AbsGeneralInsert extends AbsBaseInsert implements GeneralStatementInsert {

	protected AbsGeneralInsert(String formater) {
		if(SqlBeanFactory.hasName(formater)) {
			setGeneralFormaterInsert(SqlBeanFactory.getBean(formater, GeneralFormaterInsert.class));
		}
	}
	
	private GeneralFormaterInsert mGeneralFormaterInsert;

	@Override
	public GeneralFormaterInsert getGeneralFormaterInsert() {
		return mGeneralFormaterInsert;
	}

	@Override
	public void setGeneralFormaterInsert(GeneralFormaterInsert generalFormaterInsert) {
		mGeneralFormaterInsert = generalFormaterInsert;
	}
	
	@Override
	public void setRawFrom(String sql) {
		setBaseFrom(sql);
	}

	@Override
	public void pushRawColumn(String sql) {
		getBaseColumns(true).add(sql);
	}

	@Override
	public void pushRawValue(String sql) {
		getBaseValues(true).add(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getBaseArgs(true).add(arg);
	}

}

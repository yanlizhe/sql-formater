package net.xx.sqlFormater.statement.dialec;

import java.util.List;

import net.xx.sqlFormater.formater.GeneralFormater;
import net.xx.sqlFormater.formater.GeneralFormaterDelete;
import net.xx.sqlFormater.formater.GeneralFormaterDeleteWrapper;
import net.xx.sqlFormater.statement.BaseStatementDelete;

abstract class AbsBaseDelete extends AbsStatement implements BaseStatementDelete {
	
	@Override
	public final GeneralFormater getGeneralFormater() {
		GeneralFormaterDelete formater = getGeneralFormaterDelete();
		if (null != formater && formater instanceof GeneralFormaterDeleteWrapper) {
			formater = ((GeneralFormaterDeleteWrapper) formater).getSource();
		}
		return (GeneralFormater) formater;
	}
	
	@Override
	public final void setGeneralFormater(GeneralFormater generalFormater) {
		setGeneralFormaterDelete((GeneralFormaterDelete) generalFormater);
	}
	
	

	@Override
	public final String getSql() {
		return getGeneralFormaterDelete().getSql(getBaseFrom(), 
				getBaseFilterExecute().getBaseCondition(false));
	}

	@Override
	public final Object[] getArgs() {
		return getGeneralFormaterDelete().getArgs(getBaseFilterExecute().getBaseArgs(false));
	}
	
	
	
	@Override
	public final int execute() {
		return getGeneralFormater().getGeneralDatabase().getSpringJdbc().update(getSql(), getArgs());
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

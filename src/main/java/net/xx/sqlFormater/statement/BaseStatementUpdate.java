package net.xx.sqlFormater.statement;

import java.util.List;

import net.xx.sqlFormater.formater.GeneralFormaterUpdate;

public interface BaseStatementUpdate extends BaseStatementExecute {
	
	public List<String> getBaseSet(boolean generated);
	
	public List<Object> getBaseValues(boolean generated);
	
	public GeneralFormaterUpdate getGeneralFormaterUpdate();
	
	public void setGeneralFormaterUpdate(GeneralFormaterUpdate generalFormaterUpdate);

}

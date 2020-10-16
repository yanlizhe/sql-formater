package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.common.SqlStatement;
import net.xx.sqlFormater.formater.GeneralFormater;
import net.xx.sqlFormater.formater.InnerGeneralFormater;

public interface BaseStatement extends SqlStatement, InnerGeneralFormater, BaseMain {
	
	public GeneralFormater getGeneralFormater();
	
	public void setGeneralFormater(GeneralFormater generalFormater);

}

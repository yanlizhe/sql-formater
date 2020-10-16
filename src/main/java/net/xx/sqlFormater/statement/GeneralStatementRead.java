package net.xx.sqlFormater.statement;

import net.xx.sqlFormater.SqlGeneralRead;
import net.xx.sqlFormater.filter.GeneralFilterReadable;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.selector.GeneralSelector;

public interface GeneralStatementRead
		extends GeneralStatement, SqlGeneralRead {
	
	public GeneralFormaterRead getGeneralFormaterRead();
	
	public void setGeneralFormaterRead(GeneralFormaterRead generalFormaterRead);
	
	public GeneralSelector getGeneralSelector();
	
	public void setGeneralSelector(GeneralSelector generalSelector);
	
	public GeneralFilterReadable getGeneralFilterReadable();
	
	public void setGeneralFilterReadable(GeneralFilterReadable generalFilterReadable);

}

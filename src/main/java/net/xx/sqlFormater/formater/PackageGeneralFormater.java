package net.xx.sqlFormater.formater;

import net.xx.sqlFormater.common.SqlFormater;
import net.xx.sqlFormater.database.GeneralDatabase;

interface PackageGeneralFormater extends SqlFormater {
	
	public GeneralDatabase getGeneralDatabase();
	
	public void setGeneralDatabase(GeneralDatabase generalDatabase);

}

package net.xx.sqlFormater.formater;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.database.GeneralDatabase;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class GeneralFormaterInsertWrapper implements GeneralFormaterInsert, InitializingBean {
	
	private GeneralFormaterInsert mSource;
	
	public GeneralFormaterInsertWrapper(String database) {
		this(InnerBeanFactory.createGeneralFormaterInsert(database));
	}
	
	public GeneralFormaterInsertWrapper(GeneralFormaterInsert source) {
		mSource = source;
	}
	
	public final GeneralFormaterInsert getSource() {
		return mSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(null == getGeneralDatabase()) {
			setGeneralDatabase(SqlBeanFactory.getAuto(GeneralDatabase.class));
		}
	}

	@Override
	public GeneralDatabase getGeneralDatabase() {
		return getSource().getGeneralDatabase();
	}

	@Override
	public void setGeneralDatabase(GeneralDatabase generalDatabase) {
		getSource().setGeneralDatabase(generalDatabase);
	}

	@Override
	public String getSql(String table, List<String> columns, List<String> values) {
		return getSource().getSql(table, columns, values);
	}

	@Override
	public Object[] getArgs(List<Object> args) {
		return getSource().getArgs(args);
	}

}

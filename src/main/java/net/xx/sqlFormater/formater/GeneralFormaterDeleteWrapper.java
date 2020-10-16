package net.xx.sqlFormater.formater;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.database.GeneralDatabase;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class GeneralFormaterDeleteWrapper implements GeneralFormaterDelete, InitializingBean {
	
	private GeneralFormaterDelete mSource;
	
	public GeneralFormaterDeleteWrapper(String database) {
		this(InnerBeanFactory.createGeneralFormaterDelete(database));
	}
	
	public GeneralFormaterDeleteWrapper(GeneralFormaterDelete source) {
		mSource = source;
	}
	
	public final GeneralFormaterDelete getSource() {
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
	public String getSql(String table, List<String> conditions) {
		return getSource().getSql(table, conditions);
	}

	@Override
	public Object[] getArgs(List<Object> args) {
		return getSource().getArgs(args);
	}

}

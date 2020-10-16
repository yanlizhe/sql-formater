package net.xx.sqlFormater.formater;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.database.GeneralDatabase;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class GeneralFormaterUpdateWrapper implements GeneralFormaterUpdate, InitializingBean {
	
	private GeneralFormaterUpdate mSource;
	
	public GeneralFormaterUpdateWrapper(String database) {
		this(InnerBeanFactory.createGeneralFormaterUpdate(database));
	}
	
	public GeneralFormaterUpdateWrapper(GeneralFormaterUpdate source) {
		mSource = source;
	}
	
	public final GeneralFormaterUpdate getSource() {
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
	public String getSql(String table, List<String> sets, List<String> conditions) {
		return getSource().getSql(table, sets, conditions);
	}

	@Override
	@Deprecated
	public final Object[] getArgs(List<Object> args) {
		return getSource().getArgs(args);
	}

	@Override
	public Object[] getArgs(List<Object> values, List<Object> args) {
		return getSource().getArgs(values, args);
	}

}

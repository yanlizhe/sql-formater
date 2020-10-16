package net.xx.sqlFormater.formater;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.database.GeneralDatabase;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class GeneralFormaterReadWrapper implements GeneralFormaterRead, InitializingBean {
	
	private GeneralFormaterRead mSource;
	
	public GeneralFormaterReadWrapper(String database) {
		this(InnerBeanFactory.createGeneralFormaterRead(database));
	}
	
	public GeneralFormaterReadWrapper(GeneralFormaterRead source) {
		mSource = source;
	}
	
	public final GeneralFormaterRead getSource() {
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
	public String getSql(List<String> selection, String from, List<String> join, List<String> condition,
			List<String> groups, List<String> sort) {
		return getSource().getSql(selection, from, join, condition, groups, sort);
	}

	@Override
	public String getPagedSql(List<String> alias, List<String> selection, String from, List<String> join,
			List<String> condition, List<String> groups, List<String> sort) {
		return getSource().getPagedSql(alias, selection, from, join, condition, groups, sort);
	}

	@Override
	public Object[] getArgs(List<Object> args) {
		return getSource().getArgs(args);
	}

	@Override
	public Object[] getArgs(List<Object> args, int start, int size) {
		return getSource().getArgs(args, start, size);
	}

}

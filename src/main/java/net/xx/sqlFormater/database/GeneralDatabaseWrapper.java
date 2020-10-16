package net.xx.sqlFormater.database;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class GeneralDatabaseWrapper implements GeneralDatabase, InitializingBean {
	
	private GeneralDatabase mSource;
	
	public GeneralDatabaseWrapper() {
		this(InnerBeanFactory.createGeneralDatabase(null));
	}
	
	public GeneralDatabaseWrapper(String jdbcTemplate) {
		this(InnerBeanFactory.createGeneralDatabase(jdbcTemplate));
	}
	
	public GeneralDatabaseWrapper(GeneralDatabase source) {
		mSource = source;
	}
	
	public final GeneralDatabase getSource() {
		return mSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(null == getSpringJdbc()) {
			setSpringJdbc(SqlBeanFactory.getAuto(JdbcTemplate.class));
		}
	}

	@Override
	public JdbcTemplate getSpringJdbc() {
		return getSource().getSpringJdbc();
	}

	@Override
	public void setSpringJdbc(JdbcTemplate springJdbc) {
		getSource().setSpringJdbc(springJdbc);
	}

	@Override
	public String getOpenQuote() {
		return getSource().getOpenQuote();
	}

	@Override
	public String getCloseQuote() {
		return getSource().getCloseQuote();
	}

	@Override
	public boolean hasIndex(String indexName) {
		return getSource().hasIndex(indexName);
	}

	@Override
	public boolean hasTable(String tableName) {
		return getSource().hasTable(tableName);
	}

	@Override
	public boolean hasView(String viewName) {
		return getSource().hasView(viewName);
	}

}

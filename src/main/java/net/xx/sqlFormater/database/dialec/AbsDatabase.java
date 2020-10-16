package net.xx.sqlFormater.database.dialec;

import org.springframework.jdbc.core.JdbcTemplate;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.database.GeneralDatabase;

public abstract class AbsDatabase implements GeneralDatabase {
	
	protected AbsDatabase(String jdbcTemplate) {
		if(SqlBeanFactory.hasName(jdbcTemplate)) {
			setSpringJdbc(SqlBeanFactory.getBean(jdbcTemplate, JdbcTemplate.class));
		}
	}

	private JdbcTemplate mSpringJdbc;

	@Override
	public JdbcTemplate getSpringJdbc() {
		return mSpringJdbc;
	}

	@Override
	public void setSpringJdbc(JdbcTemplate springJdbc) {
		mSpringJdbc = springJdbc;
	}

}

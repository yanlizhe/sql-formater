package net.xx.sqlFormater.database;

import org.springframework.jdbc.core.JdbcTemplate;

interface PackageDatabase {
	
	public JdbcTemplate getSpringJdbc();
	
	public void setSpringJdbc(JdbcTemplate springJdbc);

}

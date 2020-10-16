package net.xx.sqlFormater.database;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import net.xx.sqlFormater.SqlBeanFactory;

public class GeneralPartitionedWrapper implements GeneralPartitioned, InitializingBean {
	
	private GeneralPartitioned mSource;
	
	public GeneralPartitionedWrapper(GeneralPartitioned source) {
		mSource = source;
	}
	
	public final GeneralPartitioned getSource() {
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
	public boolean hasPartition(String tableName, String partitionName) {
		return getSource().hasPartition(tableName, partitionName);
	}

	@Override
	public boolean isPartitionInsertable(String tableName, long value) {
		return getSource().isPartitionInsertable(tableName, value);
	}

	@Override
	public boolean isPartitionInsertable(String tableName, Date value) {
		return getSource().isPartitionInsertable(tableName, value);
	}

	@Override
	public boolean addPartition(String tableName, String partitionMax, String partitionName, long value) {
		return getSource().addPartition(tableName, partitionMax, partitionName, value);
	}

	@Override
	public boolean addPartition(String tableName, String partitionMax, String partitionName, Date value) {
		return getSource().addPartition(tableName, partitionMax, partitionName, value);
	}

	@Override
	public boolean movePartition(String tableName, String partitionName, String tableSpace) {
		return getSource().movePartition(tableName, partitionName, tableSpace);
	}

	@Override
	public boolean dropPartition(String tableName, String partitionName) {
		return getSource().dropPartition(tableName, partitionName);
	}

}

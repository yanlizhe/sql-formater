package net.xx.sqlFormater;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import net.xx.sqlFormater.common.SqlDatabase;
import net.xx.sqlFormater.common.SqlFormaterDelete;
import net.xx.sqlFormater.common.SqlFormaterInsert;
import net.xx.sqlFormater.common.SqlFormaterRead;
import net.xx.sqlFormater.common.SqlFormaterUpdate;
import net.xx.sqlFormater.database.GeneralDatabaseWrapper;
import net.xx.sqlFormater.filter.GeneralFilterExecuteWrapper;
import net.xx.sqlFormater.filter.GeneralFilterReadableWrapper;
import net.xx.sqlFormater.filter.StandardFilterExecuteWrapper;
import net.xx.sqlFormater.filter.StandardFilterReadableWrapper;
import net.xx.sqlFormater.formater.GeneralFormaterDeleteWrapper;
import net.xx.sqlFormater.formater.GeneralFormaterInsertWrapper;
import net.xx.sqlFormater.formater.GeneralFormaterReadWrapper;
import net.xx.sqlFormater.formater.GeneralFormaterUpdateWrapper;
import net.xx.sqlFormater.selector.GeneralSelectorWrapper;
import net.xx.sqlFormater.selector.StandardSelectorWrapper;
import net.xx.sqlFormater.selector.bean.StandardCountSelectorReadBean;
import net.xx.sqlFormater.statement.GeneralStatementDeleteWrapper;
import net.xx.sqlFormater.statement.GeneralStatementInsertWrapper;
import net.xx.sqlFormater.statement.GeneralStatementReadWrapper;
import net.xx.sqlFormater.statement.GeneralStatementUpdateWrapper;
import net.xx.sqlFormater.statement.StandardStatementDeleteWrapper;
import net.xx.sqlFormater.statement.StandardStatementInsertWrapper;
import net.xx.sqlFormater.statement.StandardStatementReadWrapper;
import net.xx.sqlFormater.statement.StandardStatementUpdateWrapper;
import net.xx.sqlFormater.util.DbType;

@Configuration
public class SqlBeanFactory extends CommonBeanFactory {
	
	private static DbType mType;
	
	public static DbType getDbType() {
		return mType;
	}
	
	public SqlBeanFactory(String type) {
		mType = DbType.getInstance(type);
	}
	
	@Bean(name = "SqlDatabase")
	public SqlDatabase createSqlDatabase() {
		return new GeneralDatabaseWrapper();
	}
	
	@Bean(name = "SqlFormaterRead")
	public SqlFormaterRead createFormaterRead() {
		return new GeneralFormaterReadWrapper("SqlDatabase");
	}
	
	@Bean(name = "SqlFormaterInsert")
	public SqlFormaterInsert createFormaterInsert() {
		return new GeneralFormaterInsertWrapper("SqlDatabase");
	}
	
	@Bean(name = "SqlFormaterUpdate")
	public SqlFormaterUpdate createFormaterUpdate() {
		return new GeneralFormaterUpdateWrapper("SqlDatabase");
	}
	
	@Bean(name = "SqlFormaterDelete")
	public SqlFormaterDelete createFormaterDelete() {
		return new GeneralFormaterDeleteWrapper("SqlDatabase");
	}
	
	@Bean(name = "SqlGeneralSelector")
	@Scope("prototype")
	public SqlGeneralSelector createSqlGeneralSelector() {
		return new GeneralSelectorWrapper();
	}
	
	@Bean(name = "SqlGeneralFilterReadable")
	@Scope("prototype")
	public SqlGeneralFilterReadable createGeneralFilterReadable() {
		return new GeneralFilterReadableWrapper();
	}
	
	@Bean(name = "SqlGeneralFilterExecute")
	@Scope("prototype")
	public SqlGeneralFilterExecute createGeneralFilterExecute() {
		return new GeneralFilterExecuteWrapper();
	}
	
	@Bean(name = "SqlGeneralRead")
	@Scope("prototype")
	public SqlGeneralRead createGeneralRead() {
		return new GeneralStatementReadWrapper("SqlGeneralSelector", "SqlGeneralFilterReadable", "SqlFormaterRead");
	}
	
	@Bean(name = "SqlGeneralInsert")
	@Scope("prototype")
	public SqlGeneralInsert createGeneralInsert() {
		return new GeneralStatementInsertWrapper("SqlFormaterInsert");
	}
	
	@Bean(name = "SqlGeneralUpdate")
	@Scope("prototype")
	public SqlGeneralUpdate createGeneralUpdate() {
		return new GeneralStatementUpdateWrapper("SqlGeneralFilterExecute", "SqlFormaterUpdate");
	}
	
	@Bean(name = "SqlGeneralDelete")
	@Scope("prototype")
	public SqlGeneralDelete createGeneralDelete() {
		return new GeneralStatementDeleteWrapper("SqlGeneralFilterExecute", "SqlFormaterDelete");
	}
	
	@Bean(name = "SqlStandardSelector")
	@Scope("prototype")
	public SqlStandardSelector createStandardSelector() {
		return new StandardSelectorWrapper();
	}
	
	@Bean(name = "SqlStandardFilterReadable")
	@Scope("prototype")
	public SqlStandardFilterReadable createStandardFilterReadable() {
		return new StandardFilterReadableWrapper();
	}
	
	@Bean(name = "SqlStandardFilterExecute")
	@Scope("prototype")
	public SqlStandardFilterExecute createStandardFilterExecute() {
		return new StandardFilterExecuteWrapper();
	}
	
	@Bean(name = "SqlStandardRead")
	@Scope("prototype")
	public SqlStandardRead createStandardRead() {
		return new StandardStatementReadWrapper("SqlStandardSelector", "SqlStandardFilterReadable", "SqlFormaterRead");
	}
	
	@Bean(name = "SqlStandardInsert")
	@Scope("prototype")
	public SqlStandardInsert createStandardInsert() {
		return new StandardStatementInsertWrapper("SqlFormaterInsert");
	}
	
	@Bean(name = "SqlStandardUpdate")
	@Scope("prototype")
	public SqlStandardUpdate createStandardUpdate() {
		return new StandardStatementUpdateWrapper("SqlStandardFilterExecute", "SqlFormaterUpdate");
	}
	
	@Bean(name = "SqlStandardDelete")
	@Scope("prototype")
	public SqlStandardDelete createStandardDelete() {
		return new StandardStatementDeleteWrapper("SqlStandardFilterExecute", "SqlFormaterDelete");
	}
	
	@Bean(name = "SqlStandardCountSelector")
	@Scope("prototype")
	public SqlStandardSelector createStandardCountSelector() {
		return new StandardCountSelectorReadBean();
	}
	
	@Bean(name = "SqlStandardReadCount")
	@Scope("prototype")
	public SqlStandardRead createStandardReadCount() {
		return new StandardStatementReadWrapper("SqlStandardCountSelector", "SqlStandardFilterReadable", "SqlFormaterRead");
	}

}

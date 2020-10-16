package net.xx.sqlFormater.util;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.database.GeneralDatabase;
import net.xx.sqlFormater.database.dialec.kingbase.KingbaseDatabaseBean;
import net.xx.sqlFormater.database.dialec.mysql.MysqlDatabaseBean;
import net.xx.sqlFormater.database.dialec.oracle.OracleDatabaseBean;
import net.xx.sqlFormater.database.dialec.sqlserver.SqlserverDatabaseBean;
import net.xx.sqlFormater.filter.GeneralFilterExecute;
import net.xx.sqlFormater.filter.GeneralFilterReadable;
import net.xx.sqlFormater.filter.StandardFilterExecute;
import net.xx.sqlFormater.filter.StandardFilterReadable;
import net.xx.sqlFormater.filter.dialec.GeneralFilterBean;
import net.xx.sqlFormater.filter.dialec.kingbase.KingbasStandardFilterExecuteBean;
import net.xx.sqlFormater.filter.dialec.kingbase.KingbasStandardFilterReadableBean;
import net.xx.sqlFormater.filter.dialec.mysql.MysqlStandardFilterExecuteBean;
import net.xx.sqlFormater.filter.dialec.mysql.MysqlStandardFilterReadableBean;
import net.xx.sqlFormater.filter.dialec.oracle.OracleStandardFilterExecuteBean;
import net.xx.sqlFormater.filter.dialec.oracle.OracleStandardFilterReadableBean;
import net.xx.sqlFormater.filter.dialec.sqlserver.SqlserverStandardFilterExecuteBean;
import net.xx.sqlFormater.filter.dialec.sqlserver.SqlserverStandardFilterReadableBean;
import net.xx.sqlFormater.formater.GeneralFormaterDelete;
import net.xx.sqlFormater.formater.GeneralFormaterInsert;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.formater.GeneralFormaterUpdate;
import net.xx.sqlFormater.formater.dialec.FormaterDeleteBean;
import net.xx.sqlFormater.formater.dialec.FormaterInsertBean;
import net.xx.sqlFormater.formater.dialec.FormaterUpdateBean;
import net.xx.sqlFormater.formater.dialec.mysql.MysqlFormaterReadBean;
import net.xx.sqlFormater.formater.dialec.oracle.OracleFormaterReadBean;
import net.xx.sqlFormater.formater.dialec.sqlserver.SqlserverFormaterReadBean;
import net.xx.sqlFormater.selector.GeneralSelector;
import net.xx.sqlFormater.selector.StandardSelector;
import net.xx.sqlFormater.selector.dialec.GeneralSelectorBean;
import net.xx.sqlFormater.selector.dialec.StandardSelectorBean;
import net.xx.sqlFormater.statement.GeneralStatementDelete;
import net.xx.sqlFormater.statement.GeneralStatementInsert;
import net.xx.sqlFormater.statement.GeneralStatementRead;
import net.xx.sqlFormater.statement.GeneralStatementUpdate;
import net.xx.sqlFormater.statement.StandardStatementDelete;
import net.xx.sqlFormater.statement.StandardStatementInsert;
import net.xx.sqlFormater.statement.StandardStatementRead;
import net.xx.sqlFormater.statement.StandardStatementUpdate;
import net.xx.sqlFormater.statement.dialec.GeneralDeleteBean;
import net.xx.sqlFormater.statement.dialec.GeneralInsertBean;
import net.xx.sqlFormater.statement.dialec.GeneralReadBean;
import net.xx.sqlFormater.statement.dialec.GeneralUpdateBean;
import net.xx.sqlFormater.statement.dialec.StandardDeleteBean;
import net.xx.sqlFormater.statement.dialec.StandardReadBean;
import net.xx.sqlFormater.statement.dialec.kingbase.KingbaseStandardInsertBean;
import net.xx.sqlFormater.statement.dialec.kingbase.KingbaseStandardUpdateBean;
import net.xx.sqlFormater.statement.dialec.mysql.MysqlStandardInsertBean;
import net.xx.sqlFormater.statement.dialec.mysql.MysqlStandardUpdateBean;
import net.xx.sqlFormater.statement.dialec.oracle.OracleStandardInsertBean;
import net.xx.sqlFormater.statement.dialec.oracle.OracleStandardUpdateBean;
import net.xx.sqlFormater.statement.dialec.sqlserver.SqlserverStandardInsertBean;
import net.xx.sqlFormater.statement.dialec.sqlserver.SqlserverStandardUpdateBean;

public class InnerBeanFactory {
    
	public static GeneralDatabase createGeneralDatabase(String jdbcTemplate) {
		switch(SqlBeanFactory.getDbType()) {
		case SQLSERVER:
			return new SqlserverDatabaseBean(jdbcTemplate);
		case ORACLE:
			return new OracleDatabaseBean(jdbcTemplate);
		case KINGBASE:
			return new KingbaseDatabaseBean(jdbcTemplate);
		default:
			return new MysqlDatabaseBean(jdbcTemplate);
		}
	}
	
	public static GeneralFormaterRead createGeneralFormaterRead(String database) {
		switch(SqlBeanFactory.getDbType()) {
		case SQLSERVER:
			return new SqlserverFormaterReadBean(database);
		case ORACLE:
		case KINGBASE:
			return new OracleFormaterReadBean(database);
		default:
			return new MysqlFormaterReadBean(database);
		}
	}
	
	public static GeneralFormaterInsert createGeneralFormaterInsert(String database) {
		return new FormaterInsertBean(database);
	}
	
	public static GeneralFormaterUpdate createGeneralFormaterUpdate(String database) {
		return new FormaterUpdateBean(database);
	}
	
	public static GeneralFormaterDelete createGeneralFormaterDelete(String database) {
		return new FormaterDeleteBean(database);
	}
	
	public static GeneralSelector createGeneralSelector() {
		return new GeneralSelectorBean();
	}
	
	public static GeneralFilterReadable createGeneralFilterReadable() {
		return new GeneralFilterBean();
	}
	
	public static GeneralFilterExecute createGeneralFilterExecute() {
		return new GeneralFilterBean();
	}
	
	public static GeneralStatementRead createGeneralStatementRead(String selector, String filter, String formater) {
		return new GeneralReadBean(selector, filter, formater);
	}
	
	public static GeneralStatementRead createGeneralStatementRead(GeneralSelector selector, GeneralFilterReadable filter) {
		return new GeneralReadBean(selector, filter);
	}
	
	public static GeneralStatementInsert createGeneralStatementInsert(String formater) {
		return new GeneralInsertBean(formater);
	}
	
	public static GeneralStatementUpdate createGeneralStatementUpdate(String filter, String formater) {
		return new GeneralUpdateBean(filter, formater);
	}
	
	public static GeneralStatementUpdate createGeneralStatementUpdate(GeneralFilterExecute filter) {
		return new GeneralUpdateBean(filter);
	}
	
	public static GeneralStatementDelete createGeneralStatementDelete(String filter, String formater) {
		return new GeneralDeleteBean(filter, formater);
	}
	
	public static GeneralStatementDelete createGeneralStatementDelete(GeneralFilterExecute filter) {
		return new GeneralDeleteBean(filter);
	}
	
	public static StandardSelector createStandardSelector() {
		return new StandardSelectorBean();
	}
	
	public static StandardFilterReadable createStandardFilterReadable() {
		switch(SqlBeanFactory.getDbType()) {
		case SQLSERVER:
			return new SqlserverStandardFilterReadableBean();
		case ORACLE:
			return new OracleStandardFilterReadableBean();
		case KINGBASE:
			return new KingbasStandardFilterReadableBean();
		default:
			return new MysqlStandardFilterReadableBean();
		}
	}
	
	public static StandardFilterExecute createStandardFilterExecute() {
		switch(SqlBeanFactory.getDbType()) {
		case SQLSERVER:
			return new SqlserverStandardFilterExecuteBean();
		case ORACLE:
			return new OracleStandardFilterExecuteBean();
		case KINGBASE:
			return new KingbasStandardFilterExecuteBean();
		default:
			return new MysqlStandardFilterExecuteBean();
		}
	}
	
	public static StandardStatementRead createStandardStatementRead(String selector, String filter, String formater) {
		return new StandardReadBean(selector, filter, formater);
	}
	
	public static StandardStatementRead createStandardStatementRead(StandardSelector selector, StandardFilterReadable filter) {
		return new StandardReadBean(selector, filter);
	}
	
	public static StandardStatementInsert createStandardStatementInsert(String formater) {
		switch(SqlBeanFactory.getDbType()) {
		case SQLSERVER:
			return new SqlserverStandardInsertBean(formater);
		case ORACLE:
			return new OracleStandardInsertBean(formater);
		case KINGBASE:
			return new KingbaseStandardInsertBean(formater);
		default:
			return new MysqlStandardInsertBean(formater);
		}
	}
	
	public static StandardStatementUpdate createStandardStatementUpdate(String filter, String formater) {
		switch(SqlBeanFactory.getDbType()) {
		case SQLSERVER:
			return new SqlserverStandardUpdateBean(filter, formater);
		case ORACLE:
			return new OracleStandardUpdateBean(filter, formater);
		case KINGBASE:
			return new KingbaseStandardUpdateBean(filter, formater);
		default:
			return new MysqlStandardUpdateBean(filter, formater);
		}
	}
	
	public static StandardStatementUpdate createStandardStatementUpdate(StandardFilterExecute filter) {
		switch(SqlBeanFactory.getDbType()) {
		case SQLSERVER:
			return new SqlserverStandardUpdateBean(filter);
		case ORACLE:
			return new OracleStandardUpdateBean(filter);
		case KINGBASE:
			return new KingbaseStandardUpdateBean(filter);
		default:
			return new MysqlStandardUpdateBean(filter);
		}
	}
	
	public static StandardStatementDelete createStandardStatementDelete(String filter, String formater) {
		return new StandardDeleteBean(filter, formater);
	}
	
	public static StandardStatementDelete createStandardStatementDelete(StandardFilterExecute filter) {
		return new StandardDeleteBean(filter);
	}

}

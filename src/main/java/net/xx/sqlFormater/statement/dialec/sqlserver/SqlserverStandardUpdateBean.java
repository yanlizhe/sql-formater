package net.xx.sqlFormater.statement.dialec.sqlserver;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.sqlserver.SqlserverDatabaseBean;
import net.xx.sqlFormater.filter.StandardFilterExecute;
import net.xx.sqlFormater.statement.dialec.AbsStandardUpdate;

public class SqlserverStandardUpdateBean extends AbsStandardUpdate {

	public SqlserverStandardUpdateBean(StandardFilterExecute filter) {
		super(filter);
	}

	public SqlserverStandardUpdateBean(String filter, String formater) {
		super(filter, formater);
	}
	
	private StandardFilterExecute mStandardFilterExecute;
	
	@Override
	public StandardFilterExecute getStandardFilterExecute() {
		return mStandardFilterExecute;
	}
	
	@Override
	public void setStandardFilterExecute(StandardFilterExecute standardFilterExecute) {
		mStandardFilterExecute = standardFilterExecute;
	}

	@Override
	public void pretreatment() {}

	@Override
	public void setDateValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATE);
			pushDateString(column, formater.format(value));
		}
	}

	@Override
	public void setDateTimeValue(String column) {
		pushDateValue(column);
	}

	@Override
	public void setDateTimeValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(SqlserverDatabaseBean.PATTERN_DATETIME);
			pushDateString(column, formater.format(value));
		}
	}

	@Override
	public void setTimestampValue(String column) {
		pushDateValue(column);
	}
	
	private void pushDateValue(String column) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" = getdate()");
		
		pushRawSet(sql.toString());
	}
	
	private void pushDateString(String column, String value) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" = cast(? as datetime)");
		pushRawSet(sql.toString());
		pushRawValue(value);
	}

}

package net.xx.sqlFormater.statement.dialec.sqlserver;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.sqlserver.SqlserverDatabaseBean;
import net.xx.sqlFormater.statement.dialec.AbsStandardInsert;

public final class SqlserverStandardInsertBean extends AbsStandardInsert {

	public SqlserverStandardInsertBean(String formater) {
		super(formater);
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
		pushRawColumn(quoted(column));
		pushRawValue("getdate()");
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
		pushRawColumn(quoted(column));
		pushRawValue("getdate()");
	}
	
	private void pushDateString(String column, String value) {
		pushRawColumn(quoted(column));
		pushRawValue("cast(? as datetime)");
		pushRawArg(value);
	}

}

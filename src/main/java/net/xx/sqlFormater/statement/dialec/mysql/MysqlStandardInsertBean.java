package net.xx.sqlFormater.statement.dialec.mysql;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.mysql.MysqlDatabaseBean;
import net.xx.sqlFormater.statement.dialec.AbsStandardInsert;

public final class MysqlStandardInsertBean extends AbsStandardInsert {

	public MysqlStandardInsertBean(String formater) {
		super(formater);
	}

	@Override
	public void pretreatment() {}

	@Override
	public void setDateValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(MysqlDatabaseBean.PATTERN_DATE);
			pushDateValue(column, formater.format(value), MysqlDatabaseBean.FORMAT_DATE);
		}
	}

	@Override
	public void setDateTimeValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(MysqlDatabaseBean.PATTERN_DATETIME);
			pushDateValue(column, formater.format(value), MysqlDatabaseBean.FORMAT_DATETIME);
		}
	}

	@Override
	public void setDateTimeValue(String column) {
		pushRawColumn(quoted(column));
		pushRawValue("sysdate()");
	}

	@Override
	public void setTimestampValue(String column) {
		pushRawColumn(quoted(column));
		pushRawValue("sysdate()");
	}

	private void pushDateValue(String column, String value, String former) {
		pushRawColumn(quoted(column));
		pushRawValue("str_to_date(?, ?)");
		pushRawArg(value);
		pushRawArg(former);
	}

}

package net.xx.sqlFormater.statement.dialec.oracle;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.oracle.OracleDatabaseBean;
import net.xx.sqlFormater.statement.dialec.AbsStandardInsert;

public final class OracleStandardInsertBean extends AbsStandardInsert {

	public OracleStandardInsertBean(String formater) {
		super(formater);
	}

	@Override
	public void pretreatment() {}

	@Override
	public void setDateValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
			pushDateValue(column, formater.format(value), OracleDatabaseBean.FORMAT_DATE);
		}
	}

	@Override
	public void setDateTimeValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
			pushDateValue(column, formater.format(value), OracleDatabaseBean.FORMAT_DATETIME);
		}
	}

	@Override
	public void setDateTimeValue(String column) {
		pushRawColumn(quoted(column));
		pushRawValue("sysdate");
	}

	@Override
	public void setTimestampValue(String column) {
		pushRawColumn(quoted(column));
		pushRawValue("systimestamp");
	}

	private void pushDateValue(String column, String value, String former) {
		pushRawColumn(quoted(column));
		pushRawValue("to_date(?, ?)");
		pushRawArg(value);
		pushRawArg(former);
	}

}

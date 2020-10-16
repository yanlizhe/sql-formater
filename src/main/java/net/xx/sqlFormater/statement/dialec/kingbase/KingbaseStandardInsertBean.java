package net.xx.sqlFormater.statement.dialec.kingbase;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.kingbase.KingbaseDatabaseBean;
import net.xx.sqlFormater.statement.dialec.AbsStandardInsert;

public final class KingbaseStandardInsertBean extends AbsStandardInsert {

	public KingbaseStandardInsertBean(String formater) {
		super(formater);
	}

	@Override
	public void pretreatment() {}

	@Override
	public void setDateValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
			setValue(column, formater.format(value));
		}
	}

	@Override
	public void setDateTimeValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
			setValue(column, formater.format(value));
		}
	}

	@Override
	public void setDateTimeValue(String column) {
		pushRawColumn(quoted(column));
		pushRawValue("SYSTIMESTAMP");
	}

	@Override
	public void setTimestampValue(String column) {
		pushRawColumn(quoted(column));
		pushRawValue("SYSTIMESTAMP");
	}

}

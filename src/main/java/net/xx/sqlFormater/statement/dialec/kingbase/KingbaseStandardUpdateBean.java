package net.xx.sqlFormater.statement.dialec.kingbase;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.oracle.OracleDatabaseBean;
import net.xx.sqlFormater.filter.StandardFilterExecute;
import net.xx.sqlFormater.statement.dialec.AbsStandardUpdate;

public final class KingbaseStandardUpdateBean extends AbsStandardUpdate {

	public KingbaseStandardUpdateBean(StandardFilterExecute filter) {
		super(filter);
	}

	public KingbaseStandardUpdateBean(String filter, String formater) {
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
			final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATE);
			setValue(column, formater.format(value));
		}
	}

	@Override
	public void setDateTimeValue(String column, Date value) {
		if (null == value) {
			setNullValue(column);
		} else {
			final SimpleDateFormat formater = new SimpleDateFormat(OracleDatabaseBean.PATTERN_DATETIME);
			setValue(column, formater.format(value));
		}
	}

	@Override
	public void setDateTimeValue(String column) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" = SYSTIMESTAMP");
		pushRawSet(sql.toString());
	}

	@Override
	public void setTimestampValue(String column) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" = SYSTIMESTAMP");
		pushRawSet(sql.toString());
	}

}

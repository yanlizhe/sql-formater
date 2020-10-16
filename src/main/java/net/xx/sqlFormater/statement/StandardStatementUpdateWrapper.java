package net.xx.sqlFormater.statement;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.CommonBeanFactory;
import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.enumerate.ConditionType;
import net.xx.sqlFormater.filter.StandardFilterExecute;
import net.xx.sqlFormater.formater.GeneralFormaterUpdate;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class StandardStatementUpdateWrapper implements StandardStatementUpdate, InitializingBean {

	/**
	 * 根据名称获取某类型的spring bean
	 * @param name bean名称
	 * @param clazz 数据类型
	 * @return spring bean
	 */
	protected static <T> T getBean(String name, Class<T> clazz) {
        return CommonBeanFactory.getBean(name, clazz);
    }
	
	private StandardStatementUpdate mSource;
	
	public StandardStatementUpdateWrapper(StandardFilterExecute filter) {
		this(InnerBeanFactory.createStandardStatementUpdate(filter));
	}
	
	public StandardStatementUpdateWrapper(String filter, String formater) {
		this(InnerBeanFactory.createStandardStatementUpdate(filter, formater));
	}
	
	public StandardStatementUpdateWrapper(StandardStatementUpdate source) {
		mSource = source;
	}
	
	public final StandardStatementUpdate getSource() {
		return mSource;
	}
	
	public void wiring() {}
	
	@Override
	public final void afterPropertiesSet() throws Exception {
		wiring();
		
		if(null == getStandardFilterExecute()) {
			setStandardFilterExecute(SqlBeanFactory.getBean("SqlStandardFilterExecute", StandardFilterExecute.class));
		}
		getStandardFilterExecute().setStandardStatementExecute(this);
		
		if(null == getGeneralFormaterUpdate()) {
			setGeneralFormaterUpdate(SqlBeanFactory.getBean("SqlFormaterUpdate", GeneralFormaterUpdate.class));
		}
		
		getStandardFilterExecute().pretreatment();
		pretreatment();
	}

	@Override
	public StandardFilterExecute getStandardFilterExecute() {
		return getSource().getStandardFilterExecute();
	}

	@Override
	public void setStandardFilterExecute(StandardFilterExecute standardFilterExecute) {
		getSource().setStandardFilterExecute(standardFilterExecute);
	}

	@Override
	public GeneralFormaterUpdate getGeneralFormaterUpdate() {
		return getSource().getGeneralFormaterUpdate();
	}

	@Override
	public void setGeneralFormaterUpdate(GeneralFormaterUpdate generalFormaterUpdate) {
		getSource().setGeneralFormaterUpdate(generalFormaterUpdate);
	}

	@Override
	public void pretreatment() {
		getSource().pretreatment();
	}

	@Override
	public void setTable(String table) {
		getSource().setTable(table);
	}

	@Override
	public void setNullValue(String column) {
		getSource().setNullValue(column);
	}

	@Override
	public void setValue(String column, Object value) {
		getSource().setValue(column, value);
	}

	@Override
	public void setByteValue(String column, Byte value) {
		getSource().setByteValue(column, value);
	}

	@Override
	public void setShortValue(String column, Short value) {
		getSource().setShortValue(column, value);
	}

	@Override
	public void setIntegerValue(String column, Integer value) {
		getSource().setIntegerValue(column, value);
	}

	@Override
	public void setLongValue(String column, Long value) {
		getSource().setLongValue(column, value);
	}

	@Override
	public void setFloatValue(String column, Float value) {
		getSource().setFloatValue(column, value);
	}

	@Override
	public void setDoubleValue(String column, Double value) {
		getSource().setDoubleValue(column, value);
	}

	@Override
	public void setStringValue(String column, String value) {
		getSource().setStringValue(column, value);
	}

	@Override
	public void setDateValue(String column, Date value) {
		getSource().setDateValue(column, value);
	}

	@Override
	public void setDateTimeValue(String column) {
		getSource().setDateTimeValue(column);
	}

	@Override
	public void setDateTimeValue(String column, Date value) {
		getSource().setDateTimeValue(column, value);
	}

	@Override
	public void setTimestampValue(String column) {
		getSource().setTimestampValue(column);
	}

	@Override
	public void pushNullCondition(String column) {
		getSource().pushNullCondition(column);
	}

	@Override
	public void pushNotNullCondition(String column) {
		getSource().pushNotNullCondition(column);
	}

	@Override
	public void pushCondition(String column, String statment) {
		getSource().pushCondition(column, statment);
	}

	@Override
	public void pushEqualByte(String column, Byte value) {
		getSource().pushEqualByte(column, value);
	}

	@Override
	public void pushEqualShort(String column, Short value) {
		getSource().pushEqualShort(column, value);
	}

	@Override
	public void pushEqualInteger(String column, Integer value) {
		getSource().pushEqualInteger(column, value);
	}

	@Override
	public void pushEqualLong(String column, Long value) {
		getSource().pushEqualLong(column, value);
	}

	@Override
	public void pushEqualFloat(String column, Float value) {
		getSource().pushEqualFloat(column, value);
	}

	@Override
	public void pushEqualDouble(String column, Double value) {
		getSource().pushEqualDouble(column, value);
	}

	@Override
	public void pushEqualString(String column, String value) {
		getSource().pushEqualString(column, value);
	}

	@Override
	public void pushArgument(String column, ConditionType condition, Object arg) {
		getSource().pushArgument(column, condition, arg);
	}

	@Override
	public void pushEqualDate(String column, Date value) {
		getSource().pushEqualDate(column, value);
	}

	@Override
	public void pushEqualDateTime(String column, Date value) {
		getSource().pushEqualDateTime(column, value);
	}

	@Override
	public void pushLargeThenDate(String column, Date value) {
		getSource().pushLargeThenDate(column, value);
	}

	@Override
	public void pushLargeThenDateTime(String column, Date value) {
		getSource().pushLargeThenDateTime(column, value);
	}

	@Override
	public void pushSmallThenDate(String column, Date value) {
		getSource().pushSmallThenDate(column, value);
	}

	@Override
	public void pushSmallThenDateTime(String column, Date value) {
		getSource().pushSmallThenDateTime(column, value);
	}

	@Override
	public void pushBetweenDate(String column, Date start, Date end) {
		getSource().pushBetweenDate(column, start, end);
	}

	@Override
	public void pushBetweenDateTime(String column, Date start, Date end) {
		getSource().pushBetweenDateTime(column, start, end);
	}

	@Override
	public String getOpenQuote() {
		return getSource().getOpenQuote();
	}

	@Override
	public String getCloseQuote() {
		return getSource().getCloseQuote();
	}

	@Override
	public String quoted(String text) {
		return getSource().quoted(text);
	}

	@Override
	public String quoted(String table, String column) {
		return getSource().quoted(table, column);
	}

	@Override
	public String getSql() {
		return getSource().getSql();
	}

	@Override
	public Object[] getArgs() {
		return getSource().getArgs();
	}

	@Override
	public int execute() {
		return getSource().execute();
	}

}

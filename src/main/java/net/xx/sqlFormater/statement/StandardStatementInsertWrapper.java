package net.xx.sqlFormater.statement;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.CommonBeanFactory;
import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.formater.GeneralFormaterInsert;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class StandardStatementInsertWrapper implements StandardStatementInsert, InitializingBean {

	/**
	 * 根据名称获取某类型的spring bean
	 * @param name bean名称
	 * @param clazz 数据类型
	 * @return spring bean
	 */
	protected static <T> T getBean(String name, Class<T> clazz) {
        return CommonBeanFactory.getBean(name, clazz);
    }
	
	private StandardStatementInsert mSource;
	
	public StandardStatementInsertWrapper(String formater) {
		this(InnerBeanFactory.createStandardStatementInsert(formater));
	}
	
	public StandardStatementInsertWrapper(StandardStatementInsert source) {
		mSource = source;
	}
	
	public final StandardStatementInsert getSource() {
		return mSource;
	}
	
	public void wiring() {}

	@Override
	public final void afterPropertiesSet() throws Exception {
		wiring();
		
		if(null == getGeneralFormaterInsert()) {
			setGeneralFormaterInsert(SqlBeanFactory.getBean("SqlFormaterInsert", GeneralFormaterInsert.class));
		}
		
		pretreatment();
	}

	@Override
	public GeneralFormaterInsert getGeneralFormaterInsert() {
		return getSource().getGeneralFormaterInsert();
	}

	@Override
	public void setGeneralFormaterInsert(GeneralFormaterInsert generalFormaterInsert) {
		getSource().setGeneralFormaterInsert(generalFormaterInsert);
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

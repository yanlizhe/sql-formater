package net.xx.sqlFormater.statement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;

import net.xx.sqlFormater.CommonBeanFactory;
import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.filter.GeneralFilterReadable;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.selector.GeneralSelector;
import net.xx.sqlFormater.util.InnerBeanFactory;
import net.xx.sqlFormater.util.JoinStatement;

public class GeneralStatementReadWrapper implements GeneralStatementRead, InitializingBean {

	/**
	 * 根据名称获取某类型的spring bean
	 * @param name bean名称
	 * @param clazz 数据类型
	 * @return spring bean
	 */
	protected static <T> T getBean(String name, Class<T> clazz) {
        return CommonBeanFactory.getBean(name, clazz);
    }
	
	private GeneralStatementRead mSource;
	
	public GeneralStatementReadWrapper(GeneralSelector selector, GeneralFilterReadable filter) {
		this(InnerBeanFactory.createGeneralStatementRead(selector, filter));
	}
	
	public GeneralStatementReadWrapper(String selector, String filter, String formater) {
		this(InnerBeanFactory.createGeneralStatementRead(selector, filter, formater));
	}
	
	public GeneralStatementReadWrapper(GeneralStatementRead source) {
		mSource = source;
	}
	
	public final GeneralStatementRead getSource() {
		return mSource;
	}
	
	public void wiring() {}

	@Override
	public final void afterPropertiesSet() throws Exception {
		wiring();
		
		if(null == getGeneralSelector()) {
			setGeneralSelector(SqlBeanFactory.getBean("SqlGeneralSelector", GeneralSelector.class));
		}
		getGeneralSelector().setGeneralStatementRead(this);
		
		if(null == getGeneralFilterReadable()) {
			setGeneralFilterReadable(SqlBeanFactory.getBean("SqlGeneralFilterReadable", GeneralFilterReadable.class));
		}
		getGeneralFilterReadable().setGeneralStatementRead(this);
		
		if(null == getGeneralFormaterRead()) {
			setGeneralFormaterRead(SqlBeanFactory.getBean("SqlFormaterRead", GeneralFormaterRead.class));
		}
		
		getGeneralFilterReadable().pretreatment();
		getGeneralSelector().pretreatment();
		pretreatment();
	}

	@Override
	public GeneralSelector getGeneralSelector() {
		return getSource().getGeneralSelector();
	}

	@Override
	public void setGeneralSelector(GeneralSelector generalSelector) {
		getSource().setGeneralSelector(generalSelector);
	}

	@Override
	public GeneralFilterReadable getGeneralFilterReadable() {
		return getSource().getGeneralFilterReadable();
	}

	@Override
	public void setGeneralFilterReadable(GeneralFilterReadable generalFilterReadable) {
		getSource().setGeneralFilterReadable(generalFilterReadable);
	}

	@Override
	public GeneralFormaterRead getGeneralFormaterRead() {
		return getSource().getGeneralFormaterRead();
	}

	@Override
	public void setGeneralFormaterRead(GeneralFormaterRead generalFormaterRead) {
		getSource().setGeneralFormaterRead(generalFormaterRead);
	}

	@Override
	public void pretreatment() {
		getSource().pretreatment();
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
	public String getPagedSql() {
		return getSource().getPagedSql();
	}

	@Override
	public Object[] getArgs(int start, int limit) {
		return getSource().getArgs();
	}

	@Override
	public Byte queryByte() {
		return getSource().queryByte();
	}

	@Override
	public Short queryShort() {
		return getSource().queryShort();
	}

	@Override
	public Integer queryInteger() {
		return getSource().queryInteger();
	}

	@Override
	public Long queryLong() {
		return getSource().queryLong();
	}

	@Override
	public Float queryFloat() {
		return getSource().queryFloat();
	}

	@Override
	public Double queryDouble() {
		return getSource().queryDouble();
	}

	@Override
	public String queryString() {
		return getSource().queryString();
	}

	@Override
	public Date queryDate() {
		return getSource().queryDate();
	}

	@Override
	public <T> T queryObject(RowMapper<T> mapper) {
		return getSource().queryObject(mapper);
	}

	@Override
	public Byte queryFirstByte() {
		return getSource().queryFirstByte();
	}

	@Override
	public Short queryFirstShort() {
		return getSource().queryFirstShort();
	}

	@Override
	public Integer queryFirstInteger() {
		return getSource().queryFirstInteger();
	}

	@Override
	public Long queryFirstLong() {
		return getSource().queryFirstLong();
	}

	@Override
	public Float queryFirstFloat() {
		return getSource().queryFirstFloat();
	}

	@Override
	public Double queryFirstDouble() {
		return getSource().queryFirstDouble();
	}

	@Override
	public String queryFirstString() {
		return getSource().queryFirstString();
	}

	@Override
	public Date queryFirstDate() {
		return getSource().queryFirstDate();
	}

	@Override
	public <T> T queryFirstObject(RowMapper<T> mapper) {
		return getSource().queryFirstObject(mapper);
	}

	@Override
	public List<Byte> queryByteList() {
		return getSource().queryByteList();
	}

	@Override
	public List<Short> queryShortList() {
		return getSource().queryShortList();
	}

	@Override
	public List<Integer> queryIntegerList() {
		return getSource().queryIntegerList();
	}

	@Override
	public List<Long> queryLongList() {
		return getSource().queryLongList();
	}

	@Override
	public List<Float> queryFloatList() {
		return getSource().queryFloatList();
	}

	@Override
	public List<Double> queryDoubleList() {
		return getSource().queryDoubleList();
	}

	@Override
	public List<String> queryStringList() {
		return getSource().queryStringList();
	}

	@Override
	public List<Date> queryDateList() {
		return getSource().queryDateList();
	}

	@Override
	public <T> List<T> queryObjectList(RowMapper<T> mapper) {
		return getSource().queryObjectList(mapper);
	}

	@Override
	public List<Byte> queryByteList(int start, int limit) {
		return getSource().queryByteList(start, limit);
	}

	@Override
	public List<Short> queryShortList(int start, int limit) {
		return getSource().queryShortList(start, limit);
	}

	@Override
	public List<Integer> queryIntegerList(int start, int limit) {
		return getSource().queryIntegerList(start, limit);
	}

	@Override
	public List<Long> queryLongList(int start, int limit) {
		return getSource().queryLongList(start, limit);
	}

	@Override
	public List<Float> queryFloatList(int start, int limit) {
		return getSource().queryFloatList(start, limit);
	}

	@Override
	public List<Double> queryDoubleList(int start, int limit) {
		return getSource().queryDoubleList(start, limit);
	}

	@Override
	public List<String> queryStringList(int start, int limit) {
		return getSource().queryStringList(start, limit);
	}

	@Override
	public List<Date> queryDateList(int start, int limit) {
		return getSource().queryDateList(start, limit);
	}

	@Override
	public <T> List<T> queryObjectList(RowMapper<T> mapper, int start, int limit) {
		return getSource().queryObjectList(mapper, start, limit);
	}

	@Override
	public void setRawFrom(String key, String sql) {
		getSource().setRawFrom(key, sql);
	}

	@Override
	public void unshiftRawJoin(String key, String sql) {
		getSource().unshiftRawJoin(key, sql);
	}

	@Override
	public void pushRawJoin(String key, String sql) {
		getSource().pushRawJoin(key, sql);
	}

	@Override
	public JoinStatement getRawJoin(String key) {
		return getSource().getRawJoin(key);
	}

	@Override
	public void refreshRawJoin(String key, String sql) {
		getSource().refreshRawJoin(key, sql);
	}

	@Override
	public void pushRawAlias(String sql) {
		getSource().pushRawAlias(sql);
	}

	@Override
	public void pushRawSelection(String sql) {
		getSource().pushRawSelection(sql);
	}

	@Override
	public void unshiftRawGroup(String sql) {
		getSource().unshiftRawGroup(sql);
	}

	@Override
	public void pushRawGroup(String sql) {
		getSource().pushRawGroup(sql);
	}

	@Override
	public void unshiftRawSort(String sql) {
		getSource().unshiftRawSort(sql);
	}

	@Override
	public void pushRawSort(String sql) {
		getSource().pushRawSort(sql);
	}

	@Override
	public void pushRawCondition(String sql) {
		getSource().pushRawCondition(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getSource().pushRawArg(arg);
	}

	@Override
	public void mergeRawArg(Object[] args) {
		getSource().mergeRawArg(args);
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

}

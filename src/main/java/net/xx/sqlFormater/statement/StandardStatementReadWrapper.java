package net.xx.sqlFormater.statement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;

import net.xx.sqlFormater.CommonBeanFactory;
import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.enumerate.ConditionType;
import net.xx.sqlFormater.enumerate.JoinType;
import net.xx.sqlFormater.filter.StandardFilterReadable;
import net.xx.sqlFormater.formater.GeneralFormaterRead;
import net.xx.sqlFormater.selector.StandardSelector;
import net.xx.sqlFormater.util.InnerBeanFactory;
import net.xx.sqlFormater.util.JoinStatement;

public class StandardStatementReadWrapper implements StandardStatementRead, InitializingBean {

	/**
	 * 根据名称获取某类型的spring bean
	 * @param name bean名称
	 * @param clazz 数据类型
	 * @return spring bean
	 */
	protected static <T> T getBean(String name, Class<T> clazz) {
        return CommonBeanFactory.getBean(name, clazz);
    }
	
	private StandardStatementRead mSource;
	
	public StandardStatementReadWrapper(StandardSelector selector, StandardFilterReadable filter) {
		this(InnerBeanFactory.createStandardStatementRead(selector, filter));
	}
	
	public StandardStatementReadWrapper(String selector, String filter, String formater) {
		this(InnerBeanFactory.createStandardStatementRead(selector, filter, formater));
	}
	
	public StandardStatementReadWrapper(StandardStatementRead source) {
		mSource = source;
	}
	
	public final StandardStatementRead getSource() {
		return mSource;
	}
	
	public void wiring() {}

	@Override
	public final void afterPropertiesSet() throws Exception {
		wiring();
		
		if(null == getStandardSelector()) {
			setStandardSelector(SqlBeanFactory.getBean("SqlStandardSelector", StandardSelector.class));
		}
		getStandardSelector().setStandardStatementRead(this);
		
		if(null == getStandardFilterReadable()) {
			setStandardFilterReadable(SqlBeanFactory.getBean("SqlStandardFilterReadable", StandardFilterReadable.class));
		}
		getStandardFilterReadable().setStandardStatementRead(this);

		if(null == getGeneralFormaterRead()) {
			setGeneralFormaterRead(SqlBeanFactory.getBean("SqlFormaterRead", GeneralFormaterRead.class));
		}

		getStandardFilterReadable().pretreatment();
		getStandardSelector().pretreatment();
		pretreatment();
	}

	@Override
	public StandardSelector getStandardSelector() {
		return getSource().getStandardSelector();
	}

	@Override
	public void setStandardSelector(StandardSelector standardSelector) {
		getSource().setStandardSelector(standardSelector);
	}

	@Override
	public StandardFilterReadable getStandardFilterReadable() {
		return getSource().getStandardFilterReadable();
	}

	@Override
	public void setStandardFilterReadable(StandardFilterReadable standardFilterReadable) {
		getSource().setStandardFilterReadable(standardFilterReadable);
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
	public void setTable(String table) {
		getSource().setTable(table);
	}

	@Override
	public void setTable(String table, String alias) {
		getSource().setTable(table, alias);
	}

	@Override
	public void pushSelection(String table, String column, String alias) {
		getSource().pushSelection(table, column, alias);
	}

	@Override
	public void pushOperationSelection(String operation, String alias) {
		getSource().pushOperationSelection(operation, alias);
	}

	@Override
	public void unshiftGroup(String table, String column) {
		getSource().unshiftGroup(table, column);
	}

	@Override
	public void pushGroup(String table, String column) {
		getSource().pushGroup(table, column);
	}

	@Override
	public void unshiftSort(String table, String column) {
		getSource().unshiftSort(table, column);
	}

	@Override
	public void unshiftSort(String table, String column, boolean isAsc) {
		getSource().unshiftSort(table, column, isAsc);
	}

	@Override
	public void pushSort(String table, String column) {
		getSource().pushSort(table, column);
	}

	@Override
	public void pushSort(String table, String column, boolean isAsc) {
		getSource().pushSort(table, column, isAsc);
	}

	@Override
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn) {
		getSource().unshiftJoin(joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void unshiftJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		getSource().unshiftJoin(joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		getSource().unshiftJoin(joinType, joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn,
			String alias) {
		getSource().unshiftJoin(joinType, joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		getSource().unshiftJoin(joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void unshiftJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns,
			String alias) {
		getSource().unshiftJoin(joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable,
			String[] refColumns) {
		getSource().unshiftJoin(joinType, joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void unshiftJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable,
			String[] refColumns, String alias) {
		getSource().unshiftJoin(joinType, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn) {
		getSource().pushJoin(joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void pushJoin(String joinTable, String joinColumn, String refTable, String refColumn, String alias) {
		getSource().pushJoin(joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn) {
		getSource().pushJoin(joinType, joinTable, joinColumn, refTable, refColumn);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String joinColumn, String refTable, String refColumn,
			String alias) {
		getSource().pushJoin(joinType, joinTable, joinColumn, refTable, refColumn, alias);
	}

	@Override
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns) {
		getSource().pushJoin(joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable,
			String[] refColumns) {
		getSource().pushJoin(joinTable, joinColumns, refTable, refColumns);
	}

	@Override
	public void pushJoin(String joinTable, String[] joinColumns, String refTable, String[] refColumns, String alias) {
		getSource().pushJoin(joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushJoin(JoinType joinType, String joinTable, String[] joinColumns, String refTable, String[] refColumns,
			String alias) {
		getSource().pushJoin(joinType, joinTable, joinColumns, refTable, refColumns, alias);
	}

	@Override
	public void pushNullCondition(String table, String column) {
		getSource().pushNullCondition(table, column);
	}

	@Override
	public void pushNotNullCondition(String table, String column) {
		getSource().pushNotNullCondition(table, column);
	}

	@Override
	public void pushCondition(String table, String column, String statment) {
		getSource().pushCondition(table, column, statment);
	}

	@Override
	public void pushEqualByte(String table, String column, Byte value) {
		getSource().pushEqualByte(table, column, value);
	}

	@Override
	public void pushEqualShort(String table, String column, Short value) {
		getSource().pushEqualShort(table, column, value);
	}

	@Override
	public void pushEqualInteger(String table, String column, Integer value) {
		getSource().pushEqualInteger(table, column, value);
	}

	@Override
	public void pushEqualLong(String table, String column, Long value) {
		getSource().pushEqualLong(table, column, value);
	}

	@Override
	public void pushEqualFloat(String table, String column, Float value) {
		getSource().pushEqualFloat(table, column, value);
	}

	@Override
	public void pushEqualDouble(String table, String column, Double value) {
		getSource().pushEqualDouble(table, column, value);
	}

	@Override
	public void pushEqualString(String table, String column, String value) {
		getSource().pushEqualString(table, column, value);
	}

	@Override
	public void pushArgument(String table, String column, ConditionType condition, Object arg) {
		getSource().pushArgument(table, column, condition, arg);
	}

	@Override
	public void pushArguments(String table, String column, Object[] values) {
		getSource().pushArguments(table, column, values);
	}

	@Override
	public void pushArguments(String[] tables, String[] columns, Object value) {
		getSource().pushArguments(tables, columns, value);
	}

	@Override
	public void pushFuzzySearch(String table, String column, String value) {
		getSource().pushFuzzySearch(table, column, value);
	}

	@Override
	public void pushFuzzySearch(String[] tables, String[] columns, String value) {
		getSource().pushFuzzySearch(tables, columns, value);
	}

	@Override
	public void pushEqualDate(String table, String column, Date value) {
		getSource().pushEqualDate(table, column, value);
	}

	@Override
	public void pushEqualDateTime(String table, String column, Date value) {
		getSource().pushEqualDateTime(table, column, value);
	}

	@Override
	public void pushLargeThenDate(String table, String column, Date value) {
		getSource().pushLargeThenDate(table, column, value);
	}

	@Override
	public void pushLargeThenDateTime(String table, String column, Date value) {
		getSource().pushLargeThenDateTime(table, column, value);
	}

	@Override
	public void pushSmallThenDate(String table, String column, Date value) {
		getSource().pushSmallThenDate(table, column, value);
	}

	@Override
	public void pushSmallThenDateTime(String table, String column, Date value) {
		getSource().pushSmallThenDateTime(table, column, value);
	}

	@Override
	public void pushLargeThenDateAndNull(String table, String column, Date value) {
		getSource().pushLargeThenDateAndNull(table, column, value);
	}

	@Override
	public void pushLargeThenDateTimeAndNull(String table, String column, Date value) {
		getSource().pushLargeThenDateTimeAndNull(table, column, value);
	}

	@Override
	public void pushSmallThenDateAndNull(String table, String column, Date value) {
		getSource().pushSmallThenDateAndNull(table, column, value);
	}

	@Override
	public void pushSmallThenDateTimeAndNull(String table, String column, Date value) {
		getSource().pushSmallThenDateTimeAndNull(table, column, value);
	}

	@Override
	public void pushBetweenDate(String table, String column, Date start, Date end) {
		getSource().pushBetweenDate(table, column, start, end);
	}

	@Override
	public void pushBetweenDateTime(String table, String column, Date start, Date end) {
		getSource().pushBetweenDateTime(table, column, start, end);
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
	public String getPagedSql() {
		return getSource().getPagedSql();
	}

	@Override
	public Object[] getArgs(int start, int limit) {
		return getSource().getArgs(start, limit);
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

}

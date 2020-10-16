package net.xx.sqlFormater.filter;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.CommonBeanFactory;
import net.xx.sqlFormater.statement.GeneralStatement;
import net.xx.sqlFormater.statement.GeneralStatementRead;
import net.xx.sqlFormater.util.InnerBeanFactory;
import net.xx.sqlFormater.util.JoinStatement;

public class GeneralFilterReadableWrapper implements GeneralFilterReadable, InitializingBean {

	/**
	 * 根据名称获取某类型的spring bean
	 * @param name bean名称
	 * @param clazz 数据类型
	 * @return spring bean
	 */
	protected static <T> T getBean(String name, Class<T> clazz) {
        return CommonBeanFactory.getBean(name, clazz);
    }
	
	private GeneralFilterReadable mSource;
	
	public GeneralFilterReadableWrapper() {
		this(InnerBeanFactory.createGeneralFilterReadable());
	}
	
	public GeneralFilterReadableWrapper(GeneralFilterReadable source) {
		mSource = source;
	}
	
	public final GeneralFilterReadable getSource() {
		return mSource;
	}
	
	public void wiring() {}

	@Override
	public final void afterPropertiesSet() throws Exception {
		wiring();
	}

	@Override
	public GeneralStatement getGeneralStatement() {
		return getSource().getGeneralStatement();
	}

	@Override
	public void setGeneralStatement(GeneralStatement generalStatement) {
		getSource().setGeneralStatement(generalStatement);
	}

	@Override
	public final GeneralStatementRead getGeneralStatementRead() {
		return getSource().getGeneralStatementRead();
	}

	@Override
	public final void setGeneralStatementRead(GeneralStatementRead generalStatementRead) {
		getSource().setGeneralStatementRead(generalStatementRead);
	}

	@Override
	public void pretreatment() {
		getSource().pretreatment();
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

/*
 * Copyright (C) 2016 Lizhe Yan.
 * 
 * Author: Lizhe Yan <yanlizhe@sina.com>
 * 
 * This file is part of sql-formater.
 * 
 * sql-formater is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later 
 * version.
 * 
 * sql-formater is distributed in the hope that it will be 
 * useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
 * PURPOSE. See the GNU Lesser General Public License for more 
 * details.
 * 
 * You should have received a copy of the GNU Lesser General 
 * Public License along with sql-formater. 
 * If not, see <https://www.gnu.org/licenses/>.
 * 
 */

package net.xx.sqlFormater.filter;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.CommonBeanFactory;
import net.xx.sqlFormater.statement.GeneralStatement;
import net.xx.sqlFormater.statement.GeneralStatementExecute;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class GeneralFilterExecuteWrapper implements GeneralFilterExecute, InitializingBean {

	/**
	 * 根据名称获取某类型的spring bean
	 * @param name bean名称
	 * @param clazz 数据类型
	 * @return spring bean
	 */
	protected static <T> T getBean(String name, Class<T> clazz) {
        return CommonBeanFactory.getBean(name, clazz);
    }
	
	private GeneralFilterExecute mSource;
	
	public GeneralFilterExecuteWrapper() {
		this(InnerBeanFactory.createGeneralFilterExecute());
	}
	
	public GeneralFilterExecuteWrapper(GeneralFilterExecute source) {
		mSource = source;
	}
	
	public final GeneralFilterExecute getSource() {
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
	public final GeneralStatementExecute getGeneralStatementExecute() {
		return getSource().getGeneralStatementExecute();
	}

	@Override
	public final void setGeneralStatementExecute(GeneralStatementExecute generalStatementExecute) {
		getSource().setGeneralStatementExecute(generalStatementExecute);
	}

	@Override
	public void pretreatment() {
		getSource().pretreatment();
	}

	@Override
	public void setRawFrom(String sql) {
		getSource().setRawFrom(sql);
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

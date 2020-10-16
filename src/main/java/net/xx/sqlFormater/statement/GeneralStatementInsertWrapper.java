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

package net.xx.sqlFormater.statement;

import org.springframework.beans.factory.InitializingBean;

import net.xx.sqlFormater.CommonBeanFactory;
import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.formater.GeneralFormaterInsert;
import net.xx.sqlFormater.util.InnerBeanFactory;

public class GeneralStatementInsertWrapper implements GeneralStatementInsert, InitializingBean {

	/**
	 * 根据名称获取某类型的spring bean
	 * @param name bean名称
	 * @param clazz 数据类型
	 * @return spring bean
	 */
	protected static <T> T getBean(String name, Class<T> clazz) {
        return CommonBeanFactory.getBean(name, clazz);
    }
	
	private GeneralStatementInsert mSource;
	
	public GeneralStatementInsertWrapper(String formater) {
		this(InnerBeanFactory.createGeneralStatementInsert(formater));
	}
	
	public GeneralStatementInsertWrapper(GeneralStatementInsert source) {
		mSource = source;
	}
	
	public final GeneralStatementInsert getSource() {
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
	public void setRawFrom(String sql) {
		getSource().setRawFrom(sql);
	}

	@Override
	public void pushRawColumn(String sql) {
		getSource().pushRawColumn(sql);
	}

	@Override
	public void pushRawValue(String sql) {
		getSource().pushRawValue(sql);
	}

	@Override
	public void pushRawArg(Object arg) {
		getSource().pushRawArg(arg);
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

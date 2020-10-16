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

package net.xx.sqlFormater;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

/**
 * Bean工厂
 * @author Liz
 */
public abstract class CommonBeanFactory implements ApplicationContextAware {

    private static final Log log = LogFactory.getLog(CommonBeanFactory.class);
    
    private static ApplicationContext mApplicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) 
			throws BeansException {
        mApplicationContext = applicationContext;
	}
	
	/**
	 * 是否存在以Bean名称为名实例
	 * @param name Bean名称
	 * @return 返回<code>true</code>表示存在，返回<code>false</code>表示不存在
	 */
	public final static boolean hasName(String name) {
		if(StringUtils.isEmpty(name)) {
			return false;
		} else {
			return mApplicationContext.containsBean(name);
		}
	}
    
	/**
	 * 根据类型查找实例
	 * @param clazz java类
	 * @return 符合条件的实例，如果没有或结果不唯一，则返回<code>null</code>
	 */
	public final static <T> T getAuto(Class<T> clazz) {
    	try {
            return mApplicationContext.getBean(clazz);
    	} catch(Exception ex) {
            log.fatal(ex);
    	}
        return null;
	}
	
	/**
	 * 根据名称查找实例
	 * @param name Bean名称
	 * @return 符合条件的实例，如果没有或结果不唯一，则返回<code>null</code>
	 */
	public final static Object getBean(String name) {
    	try {
            return mApplicationContext.getBean(name);
    	} catch(Exception ex) {
            log.fatal(ex);
    	}
        return null;
    }

	/**
	 * 根据名称和类型查找实例
	 * @param name Bean名称
	 * @param clazz java类
	 * @return 符合条件的实例，如果没有或结果不唯一，则返回<code>null</code>
	 */
	public final static <T> T getBean(String name, Class<T> clazz) {
    	try {
            return mApplicationContext.getBean(name, clazz);
    	} catch(Exception ex) {
            log.fatal(ex);
    	}
        return null;
    }

}

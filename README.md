# sql-formater

#### Usage

Settings for spring(describe the database type):
``` xml
<bean id="SqlConfiguration" class="net.xx.sqlFormater.SqlBeanFactory">
  <constructor-arg index="0" value="oracle" />
</bean>
```

A simple codding Example:
``` java
	public Integer findType(String id) {
		SqlStandardRead statement = CommonBeanFactory.getBean("SqlStandardRead", SqlStandardRead.class);
		
		statement.pushSelection("table_test", "column_type", "type");
    
		statement.setTable("table_test");

		statement.pushEqualString("table_test", "column_id", id);

		return statement.queryInteger();
	}
  
	public boolean insert(String id, String name, byte type) {
		SqlStandardInsert statement = CommonBeanFactory.getBean("SqlStandardInsert", SqlStandardInsert.class);
    
		statement.setTable("table_test");

		statement.setStringValue("column_id", id);
		statement.setStringValue("column_name", name);
		statement.setByteValue("column_type", type);
    
		return statement.execute() > 0;
	}
```

package net.xx.sqlFormater.common;

import java.util.Date;

public interface SqlPartitioned {
	
	/**
	 * 判断分区是否存在
	 * @param tableName 表名称
	 * @param partitionName 分区名称
	 * @return 如果存在返回<code>true</code>，如果不存在返回<code>false</code>
	 */
	public boolean hasPartition(String tableName, String partitionName);
	
	public boolean isPartitionInsertable(String tableName, long value);
	
	public boolean isPartitionInsertable(String tableName, Date value);
	
	public boolean addPartition(String tableName, String partitionMax, String partitionName, long value);
	
	public boolean addPartition(String tableName, String partitionMax, String partitionName, Date value);
	
	public boolean movePartition(String tableName, String partitionName, String tableSpace);
	
	public boolean dropPartition(String tableName, String partitionName);

}

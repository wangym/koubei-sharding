/**
 * 
 */
package me.yumin.sharding.client;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author xuanyin
 * 
 */
public interface IShardingStrategy {

	/**
	 * 
	 * @param hash
	 * @return
	 */
	String getDistributedByHash(int hash);

	/**
	 * 
	 * @param shardingId
	 * @return
	 */
	int getHashByShardingId(Object shardingId);

	/**
	 * 
	 * @param dbName
	 * @return
	 */
	SqlMapClient getSqlMapClientByDbName(String dbName);
}

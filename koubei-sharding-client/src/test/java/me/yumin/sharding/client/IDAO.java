/**
 * 
 */
package me.yumin.sharding.client;

import java.util.Map;

/**
 * @author xuanyin
 * 
 */
@SuppressWarnings("rawtypes")
public interface IDAO {

	// CUD By POJO

	/**
	 * 
	 * @param shardingId
	 * @param pojo
	 * @return
	 */
	boolean insertByPOJO(String shardingId, POJO pojo) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param pojo
	 * @return
	 */
	boolean updateByPOJO(String shardingId, POJO pojo) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param pojo
	 * @return
	 */
	boolean deleteByPOJO(String shardingId, POJO pojo) throws Exception;

	// CUD By Map

	/**
	 * 
	 * @param shardingId
	 * @param map
	 * @return
	 */
	boolean insertByMap(String shardingId, Map map) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param map
	 * @return
	 */
	boolean updateByMap(String shardingId, Map map) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param map
	 * @return
	 */
	boolean deleteByMap(String shardingId, Map map) throws Exception;

	// CUD By String

	/**
	 * 
	 * @param shardingId
	 * @param str
	 * @return
	 */
	boolean insertByString(String shardingId, String str) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param str
	 * @return
	 */
	boolean updateByString(String shardingId, String str) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param str
	 * @return
	 */
	boolean deleteByString(String shardingId, String str) throws Exception;

	// CUD By Integer

	/**
	 * 
	 * @param shardingId
	 * @param val
	 * @return
	 */
	boolean insertByInteger(String shardingId, Integer val) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param val
	 * @return
	 */
	boolean updateByInteger(String shardingId, Integer val) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param val
	 * @return
	 */
	boolean deleteByInteger(String shardingId, Integer val) throws Exception;

	// Select

	/**
	 * 
	 * @param shardingId
	 * @param pojo
	 * @return
	 */
	POJO selectByPOJO(String shardingId, POJO pojo) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param map
	 * @return
	 */
	POJO selectByMap(String shardingId, Map map) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param str
	 * @return
	 */
	POJO selectByString(String shardingId, String str) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param val
	 * @return
	 */
	POJO selectByInteger(String shardingId, Integer val) throws Exception;

	// Execute

	/**
	 * 
	 * @param shardingId
	 * @param sql
	 * @return
	 */
	Object execute(String shardingId, String sql) throws Exception;
}

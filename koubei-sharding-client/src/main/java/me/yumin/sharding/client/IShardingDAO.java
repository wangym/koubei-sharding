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
public interface IShardingDAO {

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param afterInvoke
	 * @return
	 */
	Object insert(Object shardingId, String sqlMapId, boolean afterInvoke) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @param afterInvoke
	 * @return
	 */
	Object insert(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param afterInvoke
	 * @return
	 */
	int update(Object shardingId, String sqlMapId, boolean afterInvoke) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @param afterInvoke
	 * @return
	 */
	int update(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param afterInvoke
	 * @return
	 */
	int delete(Object shardingId, String sqlMapId, boolean afterInvoke) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @param afterInvoke
	 * @return
	 */
	int delete(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @return
	 */
	Object queryForObject(Object shardingId, String sqlMapId) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @return
	 */
	Object queryForObject(Object shardingId, String sqlMapId, Map parameterMap) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @param resultObject
	 * @return
	 */
	Object queryForObject(Object shardingId, String sqlMapId, Map parameterMap, Object resultObject) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @param keyProp
	 * @return
	 */
	Map queryForMap(Object shardingId, String sqlMapId, Map parameterMap, String keyProp) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @param keyProp
	 * @param valueProp
	 * @return
	 */
	Map queryForMap(Object shardingId, String sqlMapId, Map parameterMap, String keyProp, String valueProp) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @param afterInvoke
	 * @return
	 */
	@Deprecated
	Object executeInsert(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @param afterInvoke
	 * @return
	 */
	@Deprecated
	int executeUpdate(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception;

	/**
	 * 
	 * @param shardingId
	 * @param sqlMapId
	 * @param parameterMap
	 * @param afterInvoke
	 * @return
	 */
	@Deprecated
	int executeDelete(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception;
}

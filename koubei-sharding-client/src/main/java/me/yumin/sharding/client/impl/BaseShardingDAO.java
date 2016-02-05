/**
 * 
 */
package me.yumin.sharding.client.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ibatis.sqlmap.client.SqlMapClient;
import me.yumin.sharding.client.IShardingDAO;
import me.yumin.sharding.client.IShardingPlugin;
import me.yumin.sharding.client.IShardingStrategy;
import me.yumin.sharding.client.etc.ShardingConfig;
import me.yumin.sharding.client.etc.ShardingUtil;

/**
 * @author xuanyin
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseShardingDAO implements IShardingDAO {

	/**
	 * 外部插件类.外部注入(可选)
	 */
	private IShardingPlugin shardingPlugin;

	/**
	 * 分布式策略.外部注入(必选)
	 */
	private IShardingStrategy shardingStrategy;

	/**
	 * 待替换表名
	 */
	private static final String TABLES = ShardingConfig.getValue(ShardingConfig.KEY_CONVERT_TABLES);

	/**
	 * 异步线程池
	 */
	private static final int PLUGIN_THREAD_SIZE = Integer.parseInt(ShardingConfig.getValue(ShardingConfig.KEY_PLUGIN_THREAD_SIZE));
	private static final ExecutorService PLUGIN_THREAD_POOL = Executors.newFixedThreadPool(PLUGIN_THREAD_SIZE);

	/**
	 * 日志操作类
	 */
	private static final Log LOG = LogFactory.getLog(BaseShardingDAO.class);

	// ====================
	// public methods
	// ====================

	@Override
	public Object insert(Object shardingId, String sqlMapId, boolean afterInvoke) throws Exception {

		Object result = null;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				result = sqlMapClient.insert(sqlMapId);
			}
		}

		if (afterInvoke) {
			afterInvoke(ShardingConfig.DB_OPTYPE_INSERT, result, shardingId, null);
		}

		return result;
	}

	@Override
	public Object insert(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception {

		Object result = null;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			int tableHash = Integer.parseInt(array[1]);
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				parameterMap = initParameterMap(parameterMap, tableHash);
				result = sqlMapClient.insert(sqlMapId, parameterMap);
			}
		}

		if (afterInvoke) {
			afterInvoke(ShardingConfig.DB_OPTYPE_INSERT, result, shardingId, parameterMap);
		}

		return result;
	}

	@Override
	public int update(Object shardingId, String sqlMapId, boolean afterInvoke) throws Exception {

		int result = -1;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				result = sqlMapClient.update(sqlMapId);
			}
		}

		if (afterInvoke) {
			afterInvoke(ShardingConfig.DB_OPTYPE_UPDATE, result, shardingId, null);
		}

		return result;
	}

	@Override
	public int update(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception {

		int result = -1;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			int tableHash = Integer.parseInt(array[1]);
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				parameterMap = initParameterMap(parameterMap, tableHash);
				result = sqlMapClient.update(sqlMapId, parameterMap);
			}
		}

		if (afterInvoke) {
			afterInvoke(ShardingConfig.DB_OPTYPE_UPDATE, result, shardingId, parameterMap);
		}

		return result;
	}

	@Override
	public int delete(Object shardingId, String sqlMapId, boolean afterInvoke) throws Exception {

		int result = -1;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				result = sqlMapClient.delete(sqlMapId);
			}
		}

		if (afterInvoke) {
			afterInvoke(ShardingConfig.DB_OPTYPE_DELETE, result, shardingId, null);
		}

		return result;
	}

	@Override
	public int delete(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception {

		int result = -1;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			int tableHash = Integer.parseInt(array[1]);
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				parameterMap = initParameterMap(parameterMap, tableHash);
				result = sqlMapClient.delete(sqlMapId, parameterMap);
			}
		}

		if (afterInvoke) {
			afterInvoke(ShardingConfig.DB_OPTYPE_DELETE, result, shardingId, parameterMap);
		}

		return result;
	}

	@Override
	public Object queryForObject(Object shardingId, String sqlMapId) throws Exception {

		Object result = null;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				result = sqlMapClient.queryForObject(sqlMapId);
			}
		}

		return result;
	}

	@Override
	public Object queryForObject(Object shardingId, String sqlMapId, Map parameterMap) throws Exception {

		Object result = null;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			int tableHash = Integer.parseInt(array[1]);
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				parameterMap = initParameterMap(parameterMap, tableHash);
				result = sqlMapClient.queryForObject(sqlMapId, parameterMap);
			}
		}

		return result;
	}

	@Override
	public Object queryForObject(Object shardingId, String sqlMapId, Map parameterMap, Object resultObject) throws Exception {

		Object result = null;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			int tableHash = Integer.parseInt(array[1]);
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				parameterMap = initParameterMap(parameterMap, tableHash);
				result = sqlMapClient.queryForObject(sqlMapId, parameterMap, resultObject);
			}
		}

		return result;
	}

	@Override
	public Map queryForMap(Object shardingId, String sqlMapId, Map parameterMap, String keyProp) throws Exception {

		Map result = null;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			int tableHash = Integer.parseInt(array[1]);
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				parameterMap = initParameterMap(parameterMap, tableHash);
				result = sqlMapClient.queryForMap(sqlMapId, parameterMap, keyProp);
			}
		}

		return result;
	}

	@Override
	public Map queryForMap(Object shardingId, String sqlMapId, Map parameterMap, String keyProp, String valueProp) throws Exception {

		Map result = null;

		String[] array = getShardingArray(shardingId);
		if (null != array && 0 < array.length) {
			String dbName = array[0];
			int tableHash = Integer.parseInt(array[1]);
			SqlMapClient sqlMapClient = shardingStrategy.getSqlMapClientByDbName(dbName);
			if (null != sqlMapClient) {
				parameterMap = initParameterMap(parameterMap, tableHash);
				result = sqlMapClient.queryForMap(sqlMapId, parameterMap, keyProp, valueProp);
			}
		}

		return result;
	}

	@Override
	public Object executeInsert(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception {

		Object result = insert(shardingId, sqlMapId, parameterMap, afterInvoke);

		return result;
	}

	@Override
	public int executeUpdate(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception {

		int result = update(shardingId, sqlMapId, parameterMap, afterInvoke);

		return result;
	}

	@Override
	public int executeDelete(Object shardingId, String sqlMapId, Map parameterMap, boolean afterInvoke) throws Exception {

		int result = delete(shardingId, sqlMapId, parameterMap, afterInvoke);

		return result;
	}

	// ====================
	// private methods
	// ====================

	/**
	 * 异步执行插件入口
	 * 
	 * @param actionName
	 * @param result
	 * @param shardingId
	 * @param parameterMap
	 */
	private void afterInvoke(final String actionName, final Object result, final Object shardingId, final Map parameterMap) {

		if (null != PLUGIN_THREAD_POOL && null != shardingPlugin) {
			PLUGIN_THREAD_POOL.execute(new Runnable() {
				@Override
				public void run() {
					shardingPlugin.afterInvoke(actionName, result, shardingId, parameterMap);
					if (Thread.interrupted()) {
						LOG.error(String.format("Thread is interrupted, shardingId=%s", shardingId));
					}
				}
			});
		}
	}

	/**
	 * 
	 * @param shardingId
	 * @return
	 */
	private String[] getShardingArray(Object shardingId) {

		String[] array = {};

		int hash = shardingStrategy.getHashByShardingId(shardingId);
		String distributed = shardingStrategy.getDistributedByHash(hash);
		array = ShardingUtil.getArrayByDistributed(distributed);

		return array;
	}

	/**
	 * 按参数类型转换,附上替换表名变量
	 * 
	 * @param parameterMap
	 * @param tableHash
	 * @return 返回结果已含所有参数并附上表名变量
	 */
	private Map initParameterMap(Map parameterMap, int tableHash) {

		if (null == parameterMap) {
			parameterMap = new HashMap();
		}
		// 默认参数(标识版本)
		parameterMap.put(ShardingConfig.KOUBEI_SHARDING_CLIENT, ShardingConfig.VERSION);

		// 表名变量
		if (null != TABLES && 0 < TABLES.length()) {
			String[] convert = TABLES.split(",");
			for (String tableName : convert) {
				// 哈希表名
				String tableFull = tableName + tableHash;
				/* 传递参数模式 */
				parameterMap.put(tableName, tableFull);
				/* 执行SQL模式 */
				if (parameterMap.containsKey(ShardingConfig.KOUBEI_SHARDING_SQL)) {
					String sql = (String) parameterMap.get(ShardingConfig.KOUBEI_SHARDING_SQL);
					String regex = "$" + tableName + "$";
					if (null != sql && sql.contains(regex)) {
						sql = sql.replace(regex, tableFull);
						parameterMap.put(ShardingConfig.KOUBEI_SHARDING_SQL, sql);
					}
				}
			}
		}

		return parameterMap;
	}

	// ====================
	// getters and setters
	// ====================

	public void setShardingPlugin(IShardingPlugin shardingPlugin) {
		this.shardingPlugin = shardingPlugin;
	}

	public void setShardingStrategy(IShardingStrategy shardingStrategy) {
		this.shardingStrategy = shardingStrategy;
	}
}

/**
 * 
 */
package com.koubei.sharding.client.impl;

import java.util.Map;
import java.util.TreeMap;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.koubei.sharding.client.IShardingStrategy;
import com.koubei.sharding.client.etc.ShardingConfig;
import com.koubei.sharding.client.etc.ShardingUtil;
import com.koubei.sharding.client.exception.ShardingException;

/**
 * @author xuanyin
 * 
 */
public final class DefaultShardingStrategy implements IShardingStrategy, InitializingBean {

	/**
	 * sqlMapConfig文件的相对路径.外部注入(必选)
	 */
	private String configLocation;

	/**
	 * Key=数据库名,Value=数据源类.外部注入(必选)
	 */
	private Map<String, DataSource> dataSourceMap;

	/**
	 * Key=连续数值,Value=数据库名\0零至表量.内部生成
	 */
	private static final Map<Integer, String> shardingMap = new TreeMap<Integer, String>();

	/**
	 * Key=数据库名,Value=库操作类.内部生成
	 */
	private static final Map<String, SqlMapClient> sqlMapClientMap = new TreeMap<String, SqlMapClient>();

	/**
	 * 数据源总数.根据dataSourceMap计算得出.内部生成
	 */
	private static int dataSourceSize;

	/**
	 * 单库表数量.防止随意调整,暂不支持配置.内部生成
	 */
	private static int tableSize;

	/**
	 * 日志操作类
	 */
	private static final Log LOG = LogFactory.getLog(DefaultShardingStrategy.class);

	// ====================
	// public methods
	// ====================

	@Override
	public void afterPropertiesSet() throws Exception {

		// 初始类内各属性值
		initProperty();
		// 初始分布式对应表
		initShardingMap();
		// 初始数据源对应表
		initSqlMapClientMap();
	}

	@Override
	public String getDistributedByHash(int hash) {

		String distributed = "";

		try {
			if (0 > hash) {
				throw new ShardingException("hash is error!");
			}
			distributed = shardingMap.get(hash);
			LOG.debug(String.format("distributed=%s", distributed));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return distributed;
	}

	@Override
	public int getHashByShardingId(Object shardingId) {

		int hash = -1;

		try {
			if (null == shardingId) {
				throw new ShardingException("shardingId is error!");
			}
			hash = ShardingUtil.getHashNode(shardingId, dataSourceSize * tableSize);
			LOG.debug(String.format("hash=%s", hash));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return hash;
	}

	@Override
	public SqlMapClient getSqlMapClientByDbName(String dbName) {

		SqlMapClient sqlMapClient = null;

		try {
			if (null == dbName) {
				throw new ShardingException("dbName is error!");
			}
			sqlMapClient = sqlMapClientMap.get(dbName);
			LOG.debug(String.format("dbName=%s", dbName));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return sqlMapClient;
	}

	// ====================
	// private methods
	// ====================

	/**
	 * 
	 */
	private void initProperty() {

		try {
			// configLocation是必选注入属性
			if (null == configLocation || 0 == configLocation.length()) {
				throw new ShardingException("property 'configLocation' can not be null!");
			}
			// dataSourceMap是必选注入属性
			if (null == dataSourceMap || 0 == dataSourceMap.size()) {
				throw new ShardingException("property 'dataSourceMap' can not be null!");
			}
			// 数据源总数
			dataSourceSize = dataSourceMap.size();
			// 单库表数量
			tableSize = Integer.parseInt(ShardingConfig.getValue(ShardingConfig.KEY_TABLE_SIZE));
			// 源及表数量
			if (1 > dataSourceSize || 1 > tableSize) {
				throw new ShardingException("property DATASOURCE_SIZE or TABLE_SIZE initialization failed!");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * 
	 */
	private void initShardingMap() {

		try {
			if (null == shardingMap || 0 == shardingMap.size()) {
				int j = 0;
				for (Map.Entry<String, DataSource> entry : dataSourceMap.entrySet()) {
					for (int i = 0; i < tableSize; i++) {
						shardingMap.put(j, entry.getKey() + ShardingConfig.SEPARATE + i);
						j++;
					}
				}
			}
			if (null != shardingMap) {
				LOG.info(String.format("shardingMap=%s", shardingMap.toString()));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * 
	 */
	private synchronized void initSqlMapClientMap() {

		try {
			if (null == sqlMapClientMap || 0 == sqlMapClientMap.size()) {
				Resource resource = new ClassPathResource(configLocation);
				if (null != resource) {
					for (Map.Entry<String, DataSource> entry : dataSourceMap.entrySet()) {
						String dbName = entry.getKey();
						DataSource dataSource = entry.getValue();
						SqlMapClientFactoryBean factory = new SqlMapClientFactoryBean();
						factory.setConfigLocation(resource);
						factory.setDataSource(dataSource);
						factory.afterPropertiesSet();
						SqlMapClient sqlMapClient = (SqlMapClient) factory.getObject();
						sqlMapClientMap.put(dbName, sqlMapClient);
					}
				}
			}
			if (null != sqlMapClientMap) {
				LOG.info(String.format("sqlMapClientMap=%s", sqlMapClientMap.toString()));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	// ====================
	// getters and setters
	// ====================

	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}

	public void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
		this.dataSourceMap = dataSourceMap;
	}
}

/**
 * 
 */
package com.koubei.sharding.client.etc;

import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author xuanyin
 * 
 */
public final class ShardingConfig {

	/**
	 * 
	 */
	public static final String SEPARATE = "\0";

	/**
	 * 
	 */
	public static final String DB_OPTYPE_INSERT = "insert";
	public static final String DB_OPTYPE_UPDATE = "update";
	public static final String DB_OPTYPE_DELETE = "delete";

	/**
	 * Key Name
	 */
	public static final String KEY_CONVERT_TABLES = "convert.tables";
	public static final String KEY_TABLE_SIZE = "table.size";
	public static final String KEY_PLUGIN_THREAD_SIZE = "plugin.thread.size";

	/**
	 * Default Value
	 */
	private static final String DEFAULT_CONVERT_TABLES = "tableName"; // 需替换数据表名(以英文逗号间隔)
	private static final int DEFAULT_TABLE_SIZE = 1; // 单数据库表数量
	private static final int DEFAULT_PLUGIN_THREAD_SIZE = 5; // 插件调用线程数

	/**
	 * 
	 */
	public static final String KOUBEI_SHARDING_CLIENT = "KOUBEI_SHARDING_CLIENT"; // 单参数开关名称
	public static final String VERSION = "1.0.5-SNAPSHOT"; // 版本号
	public static final String KOUBEI_SHARDING_SQL = "sql"; // 执行SQL的标志

	/**
	 * ResourceBundle
	 */
	private static final ResourceBundle resources = ResourceBundle.getBundle("sharding");

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ShardingConfig.class);

	/**
	 * 
	 */
	private ShardingConfig() {
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {

		String value = null;

		try {
			value = resources.getString(key);
		} catch (Exception e) {
			LOG.debug(e.getMessage(), e);
		}
		if (null == value || 0 == value.length()) {
			/* 取不到则取默认值 */
			if (KEY_CONVERT_TABLES.equalsIgnoreCase(key)) {
				return DEFAULT_CONVERT_TABLES;
			}
			if (KEY_TABLE_SIZE.equalsIgnoreCase(key)) {
				return DEFAULT_TABLE_SIZE + "";
			}
			if (KEY_PLUGIN_THREAD_SIZE.equalsIgnoreCase(key)) {
				return DEFAULT_PLUGIN_THREAD_SIZE + "";
			}
		}

		return value;
	}
}

/**
 * 
 */
package com.koubei.sharding.client;

import java.util.Map;

/**
 * @author xuanyin
 * 
 */
@SuppressWarnings("rawtypes")
public interface IShardingPlugin {

	/**
	 * 插件执行入口
	 * 
	 * @param actionName
	 * @param result
	 * @param shardingId
	 * @param parameterMap
	 * @return
	 */
	boolean afterInvoke(String actionName, Object result, Object shardingId, Map parameterMap);
}

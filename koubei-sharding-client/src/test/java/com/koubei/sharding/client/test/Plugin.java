/**
 * 
 */
package com.koubei.sharding.client.test;

import java.util.Map;
import com.koubei.sharding.client.IShardingPlugin;

/**
 * @author xuanyin
 * 
 */
@SuppressWarnings("rawtypes")
public class Plugin implements IShardingPlugin {

	@Override
	public boolean afterInvoke(String actionName, Object result, Object shardingId, Map parameterMap) {

		System.out.println("TestPlugin:" + actionName);
		return true;
	}
}

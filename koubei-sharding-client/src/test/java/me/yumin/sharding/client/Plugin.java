/**
 * 
 */
package me.yumin.sharding.client;

import java.util.Map;
import me.yumin.sharding.client.IShardingPlugin;

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

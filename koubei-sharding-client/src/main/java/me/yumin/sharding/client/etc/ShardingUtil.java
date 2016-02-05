/**
 * 
 */
package me.yumin.sharding.client.etc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;


/**
 * @author xuanyin
 * 
 */
public final class ShardingUtil {

	/**
	 * 首个字母转小写
	 * 
	 * @param word
	 * @return
	 */
	public static String firstLowercase(String word) {

		try {
			if (null != word && 0 < word.length()) {
				String first = word.substring(0, 1).toLowerCase();
				String tail = word.substring(1);
				word = new StringBuilder(first).append(tail).toString();
				first = null;
				tail = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return word;
	}

	/**
	 * 
	 * @param distributed
	 * @return
	 */
	public static String[] getArrayByDistributed(String distributed) {

		String[] shardingValueArray = {};

		try {
			if (null != distributed && 0 < distributed.length()) {
				shardingValueArray = distributed.split(ShardingConfig.SEPARATE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return shardingValueArray;
	}

	/**
	 * 
	 * @param shardingId
	 * @param databases
	 * @param tables
	 * @return
	 */
	@Deprecated
	public synchronized static String[] getHashArrayAllInOne(Object shardingId, int databases, int tables) {

		String[] hashArray = {};

		try {
			// 计算哈希值
			int hash = getHashNode(shardingId, databases * tables);
			if (0 < hash) {
				// 分配哈希表
				int x = 0;
				Map<Integer, String> shardingMap = new TreeMap<Integer, String>();
				for (int i = 0; i < databases; i++) {
					for (int j = 0; j < tables; j++) {
						shardingMap.put(x, i + ShardingConfig.SEPARATE + j);
						x++;
					}
				}
				// 获取分布式值
				String distributed = shardingMap.get(hash);
				// 分布式值分解
				hashArray = getArrayByDistributed(distributed);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hashArray;
	}

	/**
	 * 分布式哈希算法(目前求余计算)
	 * 
	 * @param shardingId
	 * @param nodeSize
	 * @return 返回(0~nodeSize-1)的某数值
	 */
	public synchronized static int getHashNode(Object shardingId, int nodeSize) {

		int hash = -1;

		try {
			if (null != shardingId && 0 < nodeSize) {
				hash = Math.abs(shardingId.hashCode() % nodeSize);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hash;
	}

	/**
	 * POJO对象转Map
	 * 
	 * @param object
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map pojoToMap(Object object) {

		Map result = new HashMap();

		try {
			final String KEY = "get";
			Map tmp = new HashMap();
			Class cls = object.getClass();
			Method[] method = cls.getDeclaredMethods();
			for (int i = 0; i < method.length; i++) {
				if (0 == method[i].getName().indexOf(KEY)) {
					int modifiers = method[i].getModifiers();
					if (1 == modifiers) {
						tmp.put(method[i].getName(), method[i].invoke(object, new Object[0]));
					}
				}
			}
			Iterator iterator = tmp.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry entry = (Entry) iterator.next();
				String key = (String) entry.getKey();
				Object value = (Object) entry.getValue();
				key = ShardingUtil.firstLowercase(key.replace(KEY, ""));
				result.put(key, value);
			}
			tmp = null;
			cls = null;
			method = null;
			iterator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}

/**
 * 
 */
package com.koubei.sharding.client.test;

import java.util.HashMap;
import java.util.Map;
import com.koubei.sharding.client.etc.ShardingConfig;
import com.koubei.sharding.client.etc.ShardingUtil;
import com.koubei.sharding.client.impl.BaseShardingDAO;

/**
 * @author xuanyin
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DAO extends BaseShardingDAO implements IDAO {

	// CUD By POJO

	@Override
	public boolean insertByPOJO(String shardingId, POJO pojo) throws Exception {

		Map parameterMap = ShardingUtil.pojoToMap(pojo);
		String insert = (String) this.insert(shardingId, "Test.insertByPOJO", parameterMap, false);
		boolean result = (null != insert && shardingId.equalsIgnoreCase(insert) ? true : false);

		return result;
	}

	@Override
	public boolean updateByPOJO(String shardingId, POJO pojo) throws Exception {

		Map parameterMap = ShardingUtil.pojoToMap(pojo);
		int update = this.update(shardingId, "Test.updateByPOJO", parameterMap, false);
		boolean result = (0 < update ? true : false);

		return result;
	}

	@Override
	public boolean deleteByPOJO(String shardingId, POJO pojo) throws Exception {

		Map parameterMap = ShardingUtil.pojoToMap(pojo);
		int delete = this.delete(shardingId, "Test.deleteByPOJO", parameterMap, false);
		boolean result = (0 < delete ? true : false);

		return result;
	}

	// CUD By Map

	@Override
	public boolean insertByMap(String shardingId, Map map) throws Exception {

		String insert = (String) this.insert(shardingId, "Test.insertByMap", map, false);
		boolean result = (null != insert && shardingId.equalsIgnoreCase(insert) ? true : false);

		return result;
	}

	@Override
	public boolean updateByMap(String shardingId, Map map) throws Exception {

		int update = this.update(shardingId, "Test.updateByMap", map, false);
		boolean result = (0 < update ? true : false);

		return result;
	}

	@Override
	public boolean deleteByMap(String shardingId, Map map) throws Exception {

		int delete = this.delete(shardingId, "Test.deleteByMap", map, false);
		boolean result = (0 < delete ? true : false);

		return result;
	}

	// CUD By String

	@Override
	public boolean insertByString(String shardingId, String str) throws Exception {

		Map parameterMap = new HashMap();
		parameterMap.put("id", str);
		String insert = (String) this.insert(shardingId, "Test.insertByString", parameterMap, false);
		boolean result = (null != insert && shardingId.equalsIgnoreCase(insert) ? true : false);

		return result;
	}

	@Override
	public boolean updateByString(String shardingId, String str) throws Exception {

		Map parameterMap = new HashMap();
		parameterMap.put("id", str);
		int update = this.update(shardingId, "Test.updateByString", parameterMap, false);
		boolean result = (0 < update ? true : false);

		return result;
	}

	@Override
	public boolean deleteByString(String shardingId, String str) throws Exception {

		Map parameterMap = new HashMap();
		parameterMap.put("id", str);
		int delete = this.delete(shardingId, "Test.deleteByString", parameterMap, false);
		boolean result = (0 < delete ? true : false);

		return result;
	}

	// CUD By Integer

	@Override
	public boolean insertByInteger(String shardingId, Integer val) throws Exception {

		Map parameterMap = new HashMap();
		parameterMap.put("id", shardingId);
		parameterMap.put("created", val);
		String insert = (String) this.insert(shardingId, "Test.insertByInteger", parameterMap, false);
		boolean result = (null != insert && shardingId.equalsIgnoreCase(insert) ? true : false);

		return result;
	}

	@Override
	public boolean updateByInteger(String shardingId, Integer val) throws Exception {

		Map parameterMap = new HashMap();
		parameterMap.put("id", shardingId);
		parameterMap.put("created", val);
		int update = this.update(shardingId, "Test.updateByInteger", parameterMap, false);
		boolean result = (0 < update ? true : false);

		return result;
	}

	@Override
	public boolean deleteByInteger(String shardingId, Integer val) throws Exception {

		Map parameterMap = new HashMap();
		parameterMap.put("id", shardingId);
		parameterMap.put("created", val);
		int delete = this.delete(shardingId, "Test.deleteByInteger", parameterMap, false);
		boolean result = (0 < delete ? true : false);

		return result;
	}

	// Select

	@Override
	public POJO selectByPOJO(String shardingId, POJO pojo) throws Exception {

		Map parameterMap = ShardingUtil.pojoToMap(pojo);

		return (POJO) this.queryForObject(shardingId, "Test.selectByPOJOResultPOJO", parameterMap);
	}

	@Override
	public POJO selectByMap(String shardingId, Map parameterMap) throws Exception {

		return (POJO) this.queryForObject(shardingId, "Test.selectByMapResultPOJO", parameterMap);
	}

	@Override
	public POJO selectByString(String shardingId, String str) throws Exception {

		Map parameterMap = new HashMap();
		parameterMap.put("id", str);

		return (POJO) this.queryForObject(shardingId, "Test.selectByStringResultPOJO", parameterMap);
	}

	@Override
	public POJO selectByInteger(String shardingId, Integer val) throws Exception {

		Map parameterMap = new HashMap();
		parameterMap.put("id", shardingId);
		parameterMap.put("created", val);

		return (POJO) this.queryForObject(shardingId, "Test.selectByIntegerResultPOJO", parameterMap);
	}

	// Execute

	@Override
	public Object execute(String shardingId, String sql) throws Exception {

		Object result = null;
		Map parameterMap = new HashMap();
		parameterMap.put(ShardingConfig.KOUBEI_SHARDING_SQL, sql);
		parameterMap.put("id", shardingId);
		if (sql.contains("insert into") || sql.contains("INSERT INTO")) {
			result = this.executeInsert(shardingId, "Test.executeInsert", parameterMap, true);
		}
		if (sql.contains("update") || sql.contains("UPDATE")) {
			result = this.executeUpdate(shardingId, "Test.executeUpdate", parameterMap, true);
		}
		if (sql.contains("delete from") || sql.contains("DELETE FROM")) {
			result = this.executeDelete(shardingId, "Test.executeDelete", parameterMap, true);
		}

		return result;
	}
}

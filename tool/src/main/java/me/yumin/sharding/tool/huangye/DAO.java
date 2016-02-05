/**
 * 
 */
package me.yumin.sharding.tool.huangye;

import java.util.HashMap;
import me.yumin.sharding.client.impl.BaseShardingDAO;

/**
 * @author xuanyin
 * 
 */
public class DAO extends BaseShardingDAO {

	/**
	 * 
	 * @param storeId
	 * @return
	 */
	public Store getStoreById(String storeId) {

		Store store = null;

		try {
			HashMap<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("id", storeId);
			store = (Store) this.queryForObject(storeId, "huangye.selectStoreById", parameterMap);
		} catch (Exception e) {
			System.out.println("DAO.getStoreById exception!");
			e.printStackTrace();
		}

		return store;
	}

	/**
	 * 
	 * @param storeId
	 * @return
	 */
	public StorePlus getStorePlusById(String storeId) {

		StorePlus storePlus = null;

		try {
			HashMap<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("id", storeId);
			storePlus = (StorePlus) this.queryForObject(storeId, "huangye.selectStorePlusById", parameterMap);
		} catch (Exception e) {
			System.out.println("DAO.getStorePlusById exception!");
			e.printStackTrace();
		}

		return storePlus;
	}

	/**
	 * 
	 * @param storeId
	 * @return
	 */
	public boolean deleteStoreById(String storeId) {

		boolean result = false;

		try {
			HashMap<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("id", storeId);
			int rows = this.delete(storeId, "huangye.deleteStoreById", parameterMap, false);
			if (0 < rows) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("DAO.deleteStoreById exception!");
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 
	 * @param storeId
	 * @return
	 */
	public boolean deleteStorePlusById(String storeId) {

		boolean result = false;

		try {
			HashMap<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("id", storeId);
			int rows = this.delete(storeId, "huangye.deleteStorePlusById", parameterMap, false);
			if (0 < rows) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("DAO.deleteStorePlusById exception!");
			e.printStackTrace();
		}

		return result;
	}
}

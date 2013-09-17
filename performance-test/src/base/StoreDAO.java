/**
 * 
 */
package base;

import java.util.HashMap;
import com.koubei.sharding.client.impl.BaseShardingDAO;
import entity.Store;

/**
 * @author xuanyin
 * 
 */
public class StoreDAO extends BaseShardingDAO implements IStoreDAO {

	@Override
	public boolean insertStore(String shardingId, Store store) {

		boolean result = false;

		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", store.getId());
			map.put("name", store.getName());
			map.put("subname", store.getSubname());
			map.put("userId", store.getUserId());
			map.put("mainCate", store.getMainCate());
			map.put("secCate", store.getSecCate());
			map.put("city", store.getCity());
			map.put("district", store.getDistrict());
			map.put("address", store.getAddress());
			map.put("isowner", store.getIsowner());
			map.put("url", store.getUrl());
			map.put("introduce", store.getIntroduce());
			map.put("status", store.getStatus());
			map.put("isopen", store.getIsopen());
			map.put("firstAppraisementUserId", store.getFirstAppraisementUserId());
			map.put("operatorFlag", store.getOperatorFlag());
			map.put("storeType", store.getStoreType());
			map.put("domain", store.getDomain());
			map.put("posx", store.getPosx());
			map.put("posy", store.getPosy());
			map.put("phoneCheck", store.getPhoneCheck());
			map.put("chkUser", store.getChkUser());
			map.put("propertyPlus", store.getPropertyPlus());
			String insert = (String) this.insert(shardingId, "SQL.insertStore", map, false);
			result = (null != insert && shardingId.equalsIgnoreCase(insert) ? true : false);
		} catch (Exception e) {
			System.err.println("=== StoreDAO.insertStore ===");
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Store selectStore(String shardingId, String storeId) {

		Store store = null;

		try {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", storeId);
			return (Store) this.queryForObject(shardingId, "SQL.selectStore", map);
		} catch (Exception e) {
			System.err.println("=== StoreDAO.selectStore ===");
			e.printStackTrace();
		}

		return store;
	}
}

/**
 * 
 */
package base;

import entity.Store;

/**
 * @author xuanyin
 * 
 */
public interface IStoreDAO {

	/**
	 * 
	 * @param shardingId
	 * @param store
	 * @return
	 */
	boolean insertStore(String shardingId, Store store);

	/**
	 * 
	 * @param shardingId
	 * @param storeId
	 * @return
	 */
	Store selectStore(String shardingId, String storeId);
}

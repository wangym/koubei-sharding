/**
 * 
 */
package test;


import base.Model;
import base.Util;
import com.koubei.sharding.client.etc.ShardingUtil;

/**
 * @author xuanyin
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String storeId = Util.getRandomUUID();
		System.out.println(ShardingUtil.pojoToMap(Model.getStore(storeId)));
	}
}

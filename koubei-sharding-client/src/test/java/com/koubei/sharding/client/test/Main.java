/**
 * 
 */
package com.koubei.sharding.client.test;

import com.koubei.sharding.client.etc.ShardingUtil;

/**
 * 
 * @author xuanyin
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String[] array = ShardingUtil.getHashArrayAllInOne("437ece91db304eabb41a982d7a543c5a", 4, 5);
		System.out.println(array[0]); // db
		System.out.println(array[1]); // tbl
	}
}

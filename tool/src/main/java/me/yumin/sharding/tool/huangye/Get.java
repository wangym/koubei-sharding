/**
 * 
 */
package me.yumin.sharding.tool.huangye;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import me.yumin.sharding.client.etc.ShardingUtil;
import me.yumin.sharding.tool.common.Constant;
import me.yumin.sharding.tool.common.Util;

/**
 * @author xuanyin
 * 
 */
public class Get {

	/**
	 * 
	 */
	private static DAO dao;

	/**
	 * 
	 */
	private static String storeId;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("===== " + new Date() + " =====");
		// 必需带参数后执行
		if (null == args || 0 == args.length) {
			System.out.println("[Get]:Please enter the args!");
			return;
		}
		storeId = args[0];
		if (null == storeId || 0 == storeId.length()) {
			System.out.println("[Get]:Please enter the arg0:storeId!");
			return;
		}
		// 初始
		init();
		// 执行
		execute();
		System.out.println("");
		System.exit(0);
	}

	/**
	 * 
	 */
	private static void init() {

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:huangye.context.xml");
			dao = (DAO) context.getBean("dao");
		} catch (Exception e) {
			System.out.println("Get.init exception!");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private static void execute() {

		try {
			if (null != dao) {
				Date date = new Date();
				String begin = "********** begin get:" + date + " **********\n";
				String storeTxt = "=== store:" + storeId + " ===\n";
				String storePlusTxt = "=== storePlus:" + storeId + " ===\n";
				String end = "********** end get:" + date + " **********\n\n";
				// 主表
				Store store = dao.getStoreById(storeId);
				if (null != store) {
					System.out.println("find [store] by storeId: " + storeId);
					Map storeMap = ShardingUtil.pojoToMap(store);
					if (null != storeMap && 0 < storeMap.size()) {
						for (Iterator it = storeMap.entrySet().iterator(); it.hasNext();) {
							Map.Entry entry = (Map.Entry) it.next();
							StringBuilder sb = new StringBuilder();
							String line = sb.append("-").append(entry.getKey()).append(":").append(entry.getValue()).append("\n").toString();
							storeTxt = storeTxt + line;
							sb = null;
							line = null;
						}
					}
				}
				// 从表
				StorePlus storePlus = dao.getStorePlusById(storeId);
				if (null != storePlus) {
					System.out.println("find [storePlus] by storeId: " + storeId);
					Map storePlusMap = ShardingUtil.pojoToMap(storePlus);
					if (null != storePlusMap && 0 < storePlusMap.size()) {
						for (Iterator it = storePlusMap.entrySet().iterator(); it.hasNext();) {
							Map.Entry entry = (Map.Entry) it.next();
							StringBuilder sb = new StringBuilder();
							String line = sb.append("-").append(entry.getKey()).append(":").append(entry.getValue()).append("\n").toString();
							storePlusTxt = storePlusTxt + line;
							sb = null;
							line = null;
						}
					}
				}
				// 写入文件
				Util.write(Constant.FILE_NAME + storeId, begin + storeTxt + storePlusTxt + end);
			}
		} catch (Exception e) {
			System.out.println("Get.execute exception!");
			e.printStackTrace();
		}
	}
}

/**
 * 
 */
package com.koubei.sharding.tool.huangye;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.koubei.sharding.tool.common.Constant;
import com.koubei.sharding.tool.common.Util;

/**
 * @author xuanyin
 * 
 */
public class Delete {

	/**
	 * 
	 */
	private static DAO dao;

	/**
	 * 文件属性
	 */
	private static String delPath;
	private static File delFile;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("===== " + new Date() + " =====");
		// 必需带参数后执行
		if (null == args || 0 == args.length) {
			System.out.println("[Delete]:Please enter the args!");
			return;
		}
		delPath = args[0];
		if (null == delPath || 0 == delPath.length()) {
			System.out.println("[Delete]:Please enter the arg0:delPath!");
			return;
		}
		delFile = new File(delPath);
		if (null == delFile || !delFile.exists() || !delFile.canRead()) {
			System.out.println("[Delete]:delPath:" + delPath + " not exists or can not read!");
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
			System.out.println("Delete.init exception!");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static void execute() {

		try {
			if (null != dao) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(delFile));
				Date date = new Date();
				String begin = "********** begin delete:" + date + " **********\n";
				String contentTxt = "", countTxt = "";
				String end = "********** end delete:" + date + " **********\n\n";
				int count = 0, success = 0;
				for (int i = 0; i < Constant.DELETE_MAX_NUM; i++) {
					String storeId = bufferedReader.readLine();
					if (null == storeId || 0 == storeId.length()) {
						count = i;
						break;
					}
					// 主表
					boolean resultStore = dao.deleteStoreById(storeId);
					StringBuilder sb = new StringBuilder();
					String line = sb.append("-[store]-").append(storeId).append(":").append(resultStore).append("\n").toString();
					contentTxt = contentTxt + line;
					sb = null;
					line = null;
					// 从表
					boolean resultStorePlus = dao.deleteStorePlusById(storeId);
					sb = new StringBuilder();
					line = sb.append("-[storePlus]-").append(storeId).append(":").append(resultStorePlus).append("\n").toString();
					contentTxt = contentTxt + line;
					if (resultStore && resultStorePlus) {
						success++;
					}
				}
				// 统计信息
				countTxt = "=== Execute.complete " + count + " lines, success " + success + " lines! ===\n";
				// 写入文件
				Util.write(Constant.FILE_NAME + "delete", begin + contentTxt + countTxt + end);
			}
		} catch (Exception e) {
			System.out.println("Delete.execute exception!");
			e.printStackTrace();
		}
	}
}

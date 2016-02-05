/**
 * 
 */
package me.yumin.sharding.tool.huangye;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import me.yumin.sharding.client.etc.ShardingConfig;
import me.yumin.sharding.tool.common.Constant;
import me.yumin.sharding.tool.common.Util;

/**
 * @author xuanyin
 * 
 */
public class Execute {

	/**
	 * 
	 */
	private static DAO dao;

	/**
	 * SQL文件属性
	 */
	private static String sqlPath;
	private static File sqlFile;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("===== " + new Date() + " =====");
		// 必需带参数后执行
		if (null == args || 0 == args.length) {
			System.out.println("[Execute]:Please enter the args!");
			return;
		}
		sqlPath = args[0];
		if (null == sqlPath || 0 == sqlPath.length()) {
			System.out.println("[Execute]:Please enter the arg0:sqlPath!");
			return;
		}
		sqlFile = new File(sqlPath);
		if (null == sqlFile || !sqlFile.exists() || !sqlFile.canRead()) {
			System.out.println("[Execute]:sqlPath:" + sqlPath + " not exists or can not read!");
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
			System.out.println("Execute.init exception!");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void execute() {

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFile));
			Date date = new Date();
			String begin = "********** begin execute:" + date + " **********\n";
			String lineTxt = "";
			String countTxt = "";
			String end = "********** end execute:" + date + " **********\n\n";
			int count = 0, success = 0;
			for (int i = 0; i < Constant.EXECUTE_MAX_NUM; i++) {
				String note = "";
				boolean opt = false;
				String line = bufferedReader.readLine();
				if (null == line || 0 == line.length()) {
					count = i;
					break;
				}
				// 提取storeId
				String storeId = "";
				Pattern pattern = Pattern.compile("(id=\")(.+?)(\")");
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					storeId = matcher.group(2);
				}
				// 执行一行sql
				if (null != storeId && 0 < storeId.length()) {
					System.out.println("===== now loading storeId:" + storeId);
					Map parameterMap = new HashMap();
					parameterMap.put(ShardingConfig.KOUBEI_SHARDING_SQL, line);
					parameterMap.put("id", storeId);
					if (line.contains("insert into") || line.contains("INSERT INTO")) {
						String result = (String) dao.executeInsert(storeId, "huangye.executeInsert", parameterMap, true);
						if (storeId.equalsIgnoreCase(result)) {
							opt = true;
							success++;
						}
					}
					if (line.contains("update") || line.contains("UPDATE")) {
						Integer result = (Integer) dao.executeUpdate(storeId, "huangye.executeUpdate", parameterMap, true);
						if (null != result && 0 < result) {
							opt = true;
							success++;
						}
					}
					if (line.contains("delete from") || line.contains("DELETE FROM")) {
						note = "can not execute 'delete' command!";
					}
					// 行结果集
					lineTxt = line + ":" + opt + " " + note + "\n" + lineTxt;
				}
			}
			// 统计信息
			countTxt = "=== Execute.complete " + count + " lines, success " + success + " lines! ===\n";
			// 写入文件
			Util.write(Constant.FILE_NAME + "execute", begin + lineTxt + countTxt + end);
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println("Execute.execute exception!");
			e.printStackTrace();
		}
	}
}

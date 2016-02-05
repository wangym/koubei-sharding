/**
 * 批量生成建表SQL
 */
package me.yumin.sharding.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

/**
 * @author xuanyin
 * 
 */
public class GenerateTable {

	/**
	 * @param args 0 File path, 1 Table size
	 */
	public static void main(String[] args) {

		try {
			// 必需带参数后执行
			if (null == args || 0 == args.length) {
				System.out.println("[TableSQL]:Please enter the args!");
				return;
			}
			/* 参数获取 */
			String filePath = args[0]; // SQL模板文件路径
			String tmpSize = args[1]; // 单库内表的数量值
			if (null == filePath || 0 == filePath.length()) {
				System.out.println("[TableSQL]:Please enter the arg0:filePath!");
				return;
			}
			if (null == tmpSize || 0 == tmpSize.length()) {
				System.out.println("[TableSQL]:Please enter the arg1:tableSize!");
				return;
			}
			// 转换为整型
			int tableSize = Integer.parseInt(tmpSize);
			// 新文件路径
			String newPath = filePath.replace(".sql", new Date().getTime() / 1000 + ".sql");
			/* 变量定义 */
			String oldLine = "";
			String oldContent = "";
			String tag = "$num$";
			String newContent = "";
			/* 获取原始SQL内容 */
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
			while (null != (oldLine = bufferedReader.readLine())) {
				oldContent += oldLine;
			}
			bufferedReader.close();
			/* 替换内容中的变量 */
			for (int i = 0; i < tableSize; i++) {
				newContent += oldContent.replace(tag, i + "");
			}
			/* 生成目标SQL文件 */
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(newPath), true));
			bufferedWriter.write(newContent);
			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

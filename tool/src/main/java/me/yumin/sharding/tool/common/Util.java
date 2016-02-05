/**
 * 
 */
package me.yumin.sharding.tool.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xuanyin
 * 
 */
public class Util {

	/**
	 * 
	 * @param fileName
	 * @param content
	 */
	public static void write(String fileName, String content) {

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), true));
			bufferedWriter.write(content);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

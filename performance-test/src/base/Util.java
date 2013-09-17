/**
 * 
 */
package base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * @author xuanyin
 * 
 */
public class Util {

	/**
	 * 
	 * @return
	 */
	public static String getRandomUUID() {

		return UUID.randomUUID().toString().replace("-", "");
	}

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

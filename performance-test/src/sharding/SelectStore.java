/**
 * 
 */
package sharding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.Store;
import base.Config;
import base.IStoreDAO;
import base.Util;

/**
 * @author xuanyin
 * 
 */
public class SelectStore extends AbstractJavaSamplerClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3010847228365854440L;

	/**
	 * 
	 */
	private static long start = 0;
	private static long end = 0;

	/**
	 * 
	 */
	private static final AtomicInteger count = new AtomicInteger();

	/**
	 * 
	 */
	private static IStoreDAO storeDAO;

	/**
	 * 
	 */
	private BufferedReader bufferedReader;

	/**
	 * 
	 */
	private void init() {

		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.application.xml");
			storeDAO = (IStoreDAO) context.getBean("storeDAO");
			bufferedReader = new BufferedReader(new FileReader(new File(Config.FILE_NAME)));
		} catch (Exception e) {
			System.err.println("=== SelectStore.init ===");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static boolean unitTest(String shardingId) {

		boolean result = false;

		try {
			String storeId = shardingId;
			Store store = storeDAO.selectStore(shardingId, shardingId);
			if (null == store || !storeId.equalsIgnoreCase(store.getId())) {
				result = false;
				System.err.println("[SelectStore] Error shardingId:" + shardingId);
			} else {
				result = true;
				count.incrementAndGet();
			}
		} catch (Exception e) {
			System.err.println("=== SelectStore.unitTest ===");
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * @param args
	 */
	public void main(String[] args) {

		// 初始化
		init();
		// param init
		String shardingId = Util.getRandomUUID();
		// start
		unitTest(shardingId);
	}

	/**
	 * 
	 */
	public Arguments getDefaultParameters() {

		Arguments args = new Arguments();
		args.addArgument(Config.KEY_READ_FILE, Config.VAL_DISABLE); // 读文件操作

		return args;
	}

	/**
	 * 
	 */
	public void setupTest(JavaSamplerContext arg) {

		// 开始时间
		start = System.currentTimeMillis();
		// start
		init();
	}

	/**
	 * 
	 */
	public void teardownTest(JavaSamplerContext arg) {

		// 结束时间
		end = System.currentTimeMillis();
		// 总体耗时
		System.err.println("[SelectStore] Cost time:" + (end - start) / 1000 + ", hit rows:" + count.get());
	}

	@Override
	public SampleResult runTest(JavaSamplerContext arg) {

		boolean result = false;
		String shardingId = "";
		SampleResult sr = new SampleResult();

		try {
			// param init
			if (Config.VAL_ENABLE.equalsIgnoreCase(arg.getParameter(Config.KEY_READ_FILE, Config.VAL_DISABLE))) {
				try {
					shardingId = bufferedReader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				shardingId = Util.getRandomUUID();
			}
			// start
			sr.sampleStart();
			result = unitTest(shardingId);
			sr.setSuccessful(result);
		} catch (Exception e) {
			System.err.println("=== SelectStore.runTest ===");
			e.printStackTrace();
			sr.setSuccessful(false);
		} finally {
			sr.sampleEnd();
		}

		return sr;
	}
}

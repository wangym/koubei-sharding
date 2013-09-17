/**
 * 
 */
package sharding;

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
import base.Model;
import base.Util;

/**
 * @author xuanyin
 * 
 */
public class InsertStore extends AbstractJavaSamplerClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6388073015232081279L;

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
	private static void init() {

		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.application.xml");
			storeDAO = (IStoreDAO) context.getBean("storeDAO");
		} catch (Exception e) {
			System.err.println("=== InsertStore.init ===");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static boolean unitTest(String shardingId) {

		boolean result = false;

		try {
			Store store = Model.getStore(shardingId);
			result = storeDAO.insertStore(shardingId, store);
			if (!result) {
				result = false;
				System.err.println("[InsertStore] Error shardingId:" + shardingId);
			} else {
				result = true;
				count.incrementAndGet();
			}
		} catch (Exception e) {
			System.err.println("=== InsertStore.unitTest ===");
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

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
		args.addArgument(Config.KEY_WRITE_FILE, Config.VAL_DISABLE); // 写文件操作

		return args;
	}

	/**
	 * 
	 */
	public void setupTest(JavaSamplerContext arg) {

		// start
		init();
		// 开始时间
		start = System.currentTimeMillis();
	}

	/**
	 * 
	 */
	public void teardownTest(JavaSamplerContext arg) {

		// 结束时间
		end = System.currentTimeMillis();
		// 总体耗时
		System.err.println("[InsertStore] Cost time:" + (end - start) / 1000 + ", affected rows:" + count.get());
	}

	@Override
	public SampleResult runTest(JavaSamplerContext arg) {

		boolean result = false;
		String shardingId = "";
		SampleResult sr = new SampleResult();

		try {
			// param init
			shardingId = Util.getRandomUUID();
			// start
			sr.sampleStart();
			result = unitTest(shardingId);
			sr.setSuccessful(result);
		} catch (Exception e) {
			System.err.println("=== InsertStore.runTest ===");
			e.printStackTrace();
			sr.setSuccessful(false);
		} finally {
			sr.sampleEnd();
		}

		if (result && Config.VAL_ENABLE.equalsIgnoreCase(arg.getParameter(Config.KEY_WRITE_FILE, Config.VAL_DISABLE))) {
			Util.write(Config.FILE_NAME, shardingId);
		}

		return sr;
	}
}

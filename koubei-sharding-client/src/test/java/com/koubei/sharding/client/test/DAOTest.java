/**
 * 
 */
package com.koubei.sharding.client.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuanyin
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DAOTest {

	/**
	 * 
	 */
	private static IDAO dao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.application.xml");
		dao = (IDAO) context.getBean("dao");
	}

	/**
	 * 
	 * @return
	 */
	private static String getRandomUUID() {

		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 
	 * @return
	 */
	private static long getUnixtime() {

		return new Date().getTime() / 1000;
	}

	// CUD By POJO

	/**
	 * 
	 * @param id
	 * @return
	 */
	private boolean insertByPOJO(String id) {

		boolean result = false;

		try {
			String name = "testInsertByPOJO";
			long time = getUnixtime();
			POJO pojo = new POJO();
			pojo.setId(id);
			pojo.setName(name);
			pojo.setCreated(time);
			pojo.setModified(time);
			result = dao.insertByPOJO(id, pojo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void testInsertByPOJO() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = insertByPOJO(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testUpdateByPOJO() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = insertByPOJO(id);
			if (result) {
				String name = "testUpdateByPOJO";
				long time = getUnixtime();
				POJO pojo = new POJO();
				pojo.setId(id);
				pojo.setName(name);
				pojo.setCreated(time);
				pojo.setModified(time);
				result = dao.updateByPOJO(id, pojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testDeleteByPOJO() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = insertByPOJO(id);
			if (result) {
				POJO pojo = new POJO();
				pojo.setId(id);
				result = dao.deleteByPOJO(id, pojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	// CUD By Map

	/**
	 * 
	 * @param id
	 * @return
	 */
	private boolean insertByMap(String id) {

		boolean result = false;

		try {
			String name = "testInsertByMap";
			long time = getUnixtime();
			Map map = new HashMap();
			map.put("id", id);
			map.put("name", name);
			map.put("created", time);
			map.put("modified", time);
			result = dao.insertByMap(id, map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void testInsertByMap() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = insertByMap(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testUpdateByMap() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = insertByMap(id);
			if (result) {
				String name = "testUpdateByMap";
				long time = getUnixtime();
				Map map = new HashMap();
				map.put("id", id);
				map.put("name", name);
				map.put("created", time);
				map.put("modified", time);
				result = dao.updateByMap(id, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testDeleteByMap() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = insertByMap(id);
			if (result) {
				Map map = new HashMap();
				map.put("id", id);
				result = dao.deleteByMap(id, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	// CUD By String

	/**
	 * 
	 * @param id
	 * @return
	 */
	private boolean insertByString(String id) {

		boolean result = false;

		try {
			result = dao.insertByString(id, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void testInsertByString() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = insertByString(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testUpdateByString() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = insertByString(id);
			if (result) {
				result = dao.updateByString(id, id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testDeleteByString() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = insertByString(id);
			if (result) {
				result = dao.deleteByString(id, id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	// CUD By Integer

	/**
	 * 
	 * @param id
	 * @param created
	 * @return
	 */
	private boolean insertByInteger(String id, int created) {

		boolean result = false;

		try {
			result = dao.insertByInteger(id, created);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void testInsertByInteger() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			int created = (int) getUnixtime();
			result = insertByInteger(id, created);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testUpdateByInteger() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			int created = (int) getUnixtime();
			result = insertByInteger(id, created);
			if (result) {
				result = dao.updateByInteger(id, created);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testDeleteByInteger() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			int created = (int) getUnixtime();
			result = insertByInteger(id, created);
			if (result) {
				result = dao.deleteByInteger(id, created);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	// Select

	@Test
	public void testSelectByPOJO() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			String name = "testInsertByPOJO";
			long time = getUnixtime();
			POJO pojo = new POJO();
			pojo.setId(id);
			pojo.setName(name);
			pojo.setCreated(time);
			pojo.setModified(time);
			result = dao.insertByPOJO(id, pojo);
			if (result) {
				result = false;
				pojo = new POJO();
				pojo.setId(id);
				POJO object = dao.selectByPOJO(id, pojo);
				if (null != object && id.equalsIgnoreCase(object.getId())) {
					result = dao.deleteByPOJO(id, pojo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testSelectByMap() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			String name = "testInsertByMap";
			long time = getUnixtime();
			Map map = new HashMap();
			map.put("id", id);
			map.put("name", name);
			map.put("created", time);
			map.put("modified", time);
			result = dao.insertByMap(id, map);
			if (result) {
				result = false;
				map = new HashMap();
				map.put("id", id);
				POJO object = dao.selectByMap(id, map);
				if (null != object && id.equalsIgnoreCase(object.getId())) {
					result = dao.deleteByMap(id, map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testSelectByString() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			result = dao.insertByString(id, id);
			if (result) {
				result = false;
				POJO object = dao.selectByString(id, id);
				if (null != object && id.equalsIgnoreCase(object.getId())) {
					result = dao.deleteByString(id, id);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testSelectByInteger() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			int created = (int) getUnixtime();
			result = dao.insertByInteger(id, created);
			if (result) {
				result = false;
				POJO object = dao.selectByInteger(id, created);
				if (0 < created && created == object.getCreated()) {
					result = dao.deleteByInteger(id, created);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	// Execute

	/**
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	private boolean insertBySQL(String id, long time) {

		boolean result = false;

		try {
			String sql = "INSERT INTO $main$ (`id`, `name`, `created`, `modified`) VALUE ('" + id + "', 'testInsertBySQL', " + time + ", " + time + ");";
			String ret = (String) dao.execute(id, sql);
			if (null != ret && id.equalsIgnoreCase(ret)) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void testInsertBySQL() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			long time = getUnixtime();
			result = insertBySQL(id, time);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testUpdateBySQL() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			long time = getUnixtime();
			result = insertBySQL(id, time);
			if (result) {
				String sql = "UPDATE $main$ SET name='testUpdateBySQL' WHERE id = '" + id + "'";
				Integer ret = (Integer) dao.execute(id, sql);
				if (null != ret && 1 == ret) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}

	@Test
	public void testDeleteBySQL() {

		boolean result = false;

		try {
			String id = getRandomUUID();
			long time = getUnixtime();
			result = insertBySQL(id, time);
			if (result) {
				String sql = "DELETE FROM $main$ WHERE id = '" + id + "'";
				Integer ret = (Integer) dao.execute(id, sql);
				if (null != ret && 1 == ret) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, result);
	}
}

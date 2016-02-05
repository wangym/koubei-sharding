/**
 * 
 */
package me.yumin.sharding.client;

/**
 * @author xuanyin
 * 
 */
public class POJO {

	/**
	 * 
	 */
	public String id;
	public String name;
	public long created;
	public long modified;

	/**
	 * 
	 */
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getCreated() {
		return created;
	}

	public long getModified() {
		return modified;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public void setModified(long modified) {
		this.modified = modified;
	}
}

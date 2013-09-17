/**
 * 
 */
package entity;

import java.io.Serializable;

/**
 * @author xuanyin
 * 
 */
public class StorePlus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1106612159374178085L;

	/**
	 * 
	 */
	// 表的主键
	private String id;
	// 统计信息
	private String statistic;
	// 折扣信息
	private String discount;
	// 联系信息
	private String contact;
	// 联系信息
	private String kpinfo;

	/**
	 * 
	 */
	public String getId() {
		return id;
	}

	public String getStatistic() {
		return statistic;
	}

	public String getDiscount() {
		return discount;
	}

	public String getContact() {
		return contact;
	}

	public String getKpinfo() {
		return kpinfo;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStatistic(String statistic) {
		this.statistic = statistic;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setKpinfo(String kpinfo) {
		this.kpinfo = kpinfo;
	}
}

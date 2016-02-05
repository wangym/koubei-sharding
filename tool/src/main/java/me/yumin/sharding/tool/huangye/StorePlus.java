/**
 * 
 */
package me.yumin.sharding.tool.huangye;

import java.io.Serializable;

/**
 * @author xuanyin
 * 
 */
public class StorePlus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4468843610393579176L;

	/**
	 * 
	 */
	// 表的主键
	private String id;
	//
	private String statistic;
	//
	private String discount;
	//
	private String contact;
	//
	private String kpinfo;

	/**
	 * 
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatistic() {
		return statistic;
	}

	public void setStatistic(String statistic) {
		this.statistic = statistic;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getKpinfo() {
		return kpinfo;
	}

	public void setKpinfo(String kpinfo) {
		this.kpinfo = kpinfo;
	}
}

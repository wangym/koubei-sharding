/**
 * 
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xuanyin
 * 
 */
public class Store implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4197361270230967493L;

	/**
	 * 
	 */
	// 表的主键
	private String id;
	// 店铺名称
	private String name;
	// 分店名称
	private String subname;
	// 用户Pin
	private int userId;
	// 主营类目
	private String mainCate;
	// 辅营类目
	private String secCate;
	// 城市编号
	private int city;
	// 区域编号
	private int district;
	// 店铺地址
	private String address;
	// 发布时间
	private Date createTime;
	// 修改时间
	private Date modifyTime;
	// 是否店主(0非店主,1是店主)
	private Integer isowner;
	// 店铺网址
	private String url;
	// 店铺介绍
	private String introduce;
	// 状态(0未审 1通过 2修改 3待定 4后台删除 5用户删除)
	private int status;
	// 是否歇业(0正常 1暂停 2歇业)
	private int isopen;
	// 首发点评的用户Id
	private int firstAppraisementUserId;
	// 操作标识(0网站登记 1手机登记 2扫街数据)
	private int operatorFlag;
	// 店铺类型(1普通店铺 2旺铺 3免费网店 5网购通店铺)
	private int storeType = 1;
	// FreeDian域名
	private String domain;
	// 坐标x轴
	private int posx;
	// 坐标y轴
	private int posy;
	// 电话核实字段
	private int phoneCheck;
	// 电话核实时间
	private Date phoneChkTime;
	// 审核人名
	private String chkUser;
	// 审核时间
	private Date chkTime;
	// 动态配置属性
	private String propertyPlus;

	/**
	 * 
	 */
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSubname() {
		return subname;
	}

	public int getUserId() {
		return userId;
	}

	public String getMainCate() {
		return mainCate;
	}

	public String getSecCate() {
		return secCate;
	}

	public int getCity() {
		return city;
	}

	public int getDistrict() {
		return district;
	}

	public String getAddress() {
		return address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public Integer getIsowner() {
		return isowner;
	}

	public String getUrl() {
		return url;
	}

	public String getIntroduce() {
		return introduce;
	}

	public int getStatus() {
		return status;
	}

	public int getIsopen() {
		return isopen;
	}

	public int getFirstAppraisementUserId() {
		return firstAppraisementUserId;
	}

	public int getOperatorFlag() {
		return operatorFlag;
	}

	public int getStoreType() {
		return storeType;
	}

	public String getDomain() {
		return domain;
	}

	public int getPosx() {
		return posx;
	}

	public int getPosy() {
		return posy;
	}

	public int getPhoneCheck() {
		return phoneCheck;
	}

	public Date getPhoneChkTime() {
		return phoneChkTime;
	}

	public String getChkUser() {
		return chkUser;
	}

	public Date getChkTime() {
		return chkTime;
	}

	public String getPropertyPlus() {
		return propertyPlus;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setMainCate(String mainCate) {
		this.mainCate = mainCate;
	}

	public void setSecCate(String secCate) {
		this.secCate = secCate;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public void setIsowner(Integer isowner) {
		this.isowner = isowner;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setIsopen(int isopen) {
		this.isopen = isopen;
	}

	public void setFirstAppraisementUserId(int firstAppraisementUserId) {
		this.firstAppraisementUserId = firstAppraisementUserId;
	}

	public void setOperatorFlag(int operatorFlag) {
		this.operatorFlag = operatorFlag;
	}

	public void setStoreType(int storeType) {
		this.storeType = storeType;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public void setPhoneCheck(int phoneCheck) {
		this.phoneCheck = phoneCheck;
	}

	public void setPhoneChkTime(Date phoneChkTime) {
		this.phoneChkTime = phoneChkTime;
	}

	public void setChkUser(String chkUser) {
		this.chkUser = chkUser;
	}

	public void setChkTime(Date chkTime) {
		this.chkTime = chkTime;
	}

	public void setPropertyPlus(String propertyPlus) {
		this.propertyPlus = propertyPlus;
	}
}

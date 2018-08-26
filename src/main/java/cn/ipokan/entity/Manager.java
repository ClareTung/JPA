package cn.ipokan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
* @author 作者 :董唐强
* @version 创建时间：2018年8月26日 上午10:25:13
* 说明：
*/
@Table(name="JPA_MANAGERS")
@Entity
public class Manager {
	
	private Integer id;
	private String mgrName;
	
	private Department dept;

	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="MGR_NAME")
	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	//对于不维护关联关系, 没有外键的一方, 使用 @OneToOne 来进行映射, 建议设置 mappedBy=true
	@OneToOne(mappedBy="mgr")
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
}

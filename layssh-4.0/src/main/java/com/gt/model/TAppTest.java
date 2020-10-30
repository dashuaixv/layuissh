package com.gt.model;

import com.gt.pageModel.BasePageForLayUI;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @功能说明：测试管理
 * @作者： herun
 * @创建日期：2018-09-20
 * @版本号：V1.0
 */
@Entity
@Table(name = "t_app_test", schema = "")
public class TAppTest extends BasePageForLayUI implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String myuuid;//主键

	private String name;//姓名

	private String sex;//性别

	private String age;//年纪


	//构造方法
	public TAppTest() {
	}
	
	
	@Id @Column( name = "myuuid"  ,nullable = false  , length = 36  )
	public String getMyuuid() {
		return  myuuid;
	}

	public void setMyuuid(String myuuid) {
		this.myuuid = myuuid;
	}

	
	@Column( name = "name"  , length = 50  )
	public String getName() {
		return  name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Column( name = "sex"  , length = 1  )
	public String getSex() {
		return  sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
	@Column( name = "age"  , length = 1  )
	public String getAge() {
		return  age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}

package com.bw.bean;


public class Engineer implements java.io.Serializable {

	//columns START
	private Integer eid;
	private String ename;
	private String sex;
	private String area;
	private String gboos;
	private String spname;
	private Integer pid1;
	private Integer pid2;
	private String num;
	private Integer registnum;
	private String time;
	//columns END
	public Engineer(){
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getGboos() {
		return gboos;
	}
	public void setGboos(String gboos) {
		this.gboos = gboos;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public Integer getPid1() {
		return pid1;
	}
	public void setPid1(Integer pid1) {
		this.pid1 = pid1;
	}
	public Integer getPid2() {
		return pid2;
	}
	public void setPid2(Integer pid2) {
		this.pid2 = pid2;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Integer getRegistnum() {
		return registnum;
	}
	public void setRegistnum(Integer registnum) {
		this.registnum = registnum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Engineer(Integer eid, String ename, String sex, String area, String gboos, String spname, Integer pid1,
			Integer pid2, String num, Integer registnum, String time) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sex = sex;
		this.area = area;
		this.gboos = gboos;
		this.spname = spname;
		this.pid1 = pid1;
		this.pid2 = pid2;
		this.num = num;
		this.registnum = registnum;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Engineer [eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", area=" + area + ", gboos=" + gboos
				+ ", spname=" + spname + ", pid1=" + pid1 + ", pid2=" + pid2 + ", num=" + num + ", registnum="
				+ registnum + ", time=" + time + "]";
	}

}


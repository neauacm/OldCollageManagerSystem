package xin.miku.hat.classbean;

import com.mysql.fabric.xmlrpc.base.Data;

public class Classbean {
	private String classname;//课程名
	
	private String Classid;//课程id
	
	private String teacherid;//教师id
	
	private int xueshi;//学时
	
	private String time;//上课时间
	
	private String jiaoshi;//教室
	

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClassid() {
		return Classid;
	}

	public void setClassid(String classid) {
		Classid = classid;
	}

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public int getXueshi() {
		return xueshi;
	}

	public void setXueshi(int xueshi) {
		this.xueshi = xueshi;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getJiaoshi() {
		return jiaoshi;
	}

	public void setJiaoshi(String jiaoshi) {
		this.jiaoshi = jiaoshi;
	}

	
}

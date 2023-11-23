package com.cg.model;

public class Family {
	private int familymem;
	private String familyadd;
	private String fathername;
	public Family(int familymem, String familyadd, String fathername) {
		//super();
		this.familymem = familymem;
		this.familyadd = familyadd;
		this.fathername = fathername;
	}
	public int getFamilymem() {
		return familymem;
	}
	public void setFamilymem(int familymem) {
		this.familymem = familymem;
	}
	public String getFamilyadd() {
		return familyadd;
	}
	public void setFamilyadd(String familyadd) {
		this.familyadd = familyadd;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	@Override
	public String toString() {
		return "Family [familymem=" + familymem + ", familyadd=" + familyadd + ", fathername=" + fathername + "]";
	}
	

}

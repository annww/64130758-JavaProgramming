package com.example.demobanhang_64130758;

public class Product {
		private int id;
		private String tenSP;
		private String giaSP;
		private String moTa;

	public Product(int id, String tenSP, String giaSP, String moTa) {
		this.id = id;
		this.tenSP = tenSP;
		this.giaSP = giaSP;
		this.moTa = moTa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(String giaSP) {
		this.giaSP = giaSP;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
}

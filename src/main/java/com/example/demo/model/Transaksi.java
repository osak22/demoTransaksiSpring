package com.example.demo.model;

import javax.persistence.*;

// tabel Transaksi di database
@Entity
public class Transaksi {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment

	
	private Integer id;
	private Integer amount;
	private String date;
	private String time;
	private String remark;
	
	// tabel version buat update
    @Version
    @Column(name = "optVersion", columnDefinition = "integer DEFAULT 0")
    private Integer version;
	
	public Integer getAmount() {
		return amount;
	}
	public Integer getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public String getRemark() {
		return remark;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}


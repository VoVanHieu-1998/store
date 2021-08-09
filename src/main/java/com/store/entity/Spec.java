package com.store.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity(name="specs")
public class Spec{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer specsId;
	
	private int itemStatus;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date createDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date updateDate;
	
	@javax.persistence.Transient
	private String gotValue;

	@javax.persistence.Transient
	private BigDecimal gotPriceMin;
	
	@OneToMany(mappedBy="spec_specDetail",fetch=FetchType.EAGER)
	private Set<SpecDetail> specDetails;
	
	
	public String getGotValue() {
		return gotValue;
	}
	public void setGotValue(String gotValue) {
		this.gotValue = gotValue;
	}

	

	public BigDecimal getGotPriceMin() {
		return gotPriceMin;
	}
	public void setGotPriceMin(BigDecimal gotPriceMin) {
		this.gotPriceMin = gotPriceMin;
	}

	public Integer getSpecsId() {
		return specsId;
	}

	public void setSpecsId(Integer specsId) {
		this.specsId = specsId;
	}

	public int getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Set<SpecDetail> getSpecDetails() {
		return specDetails;
	}
	public void setSpecDetails(Set<SpecDetail> specDetails) {
		this.specDetails = specDetails;
	}
	
	
	
	
	@Transient
	public void getValByName(String name) {		
		Set<SpecDetail> list = getSpecDetails();
		for(SpecDetail sd: list) {
			if(sd.getName().equals(name)){
				this.gotValue= sd.getValue();
			}
		}		
	}
	
	
	
}

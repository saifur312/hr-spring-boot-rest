package com.bs.hrm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.bs.hrm.entity.ids.AddressId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(AddressId.class)
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
@Data @Builder(toBuilder = true)
public class Address {
	
	@Id
	private Long 			addressId;
	@Id 
	private Long 			employeeId;
	@Column(length=30)
	private String 			addressType;
//	private Integer 		divisionCode;
//	private Integer 		districtCode;
//	private Integer 		subDistrictCode;
	private String 			division;
	private String 			district;
	private String 			subDistrict;
	private String 			city;
	private String 			village;
	private String 			postalCode;
	private String 			area;
	@Column(length=80)
	private String 			region;
	@Column(length=50)
	private String 			roadNo;
	@Column(length=50)
	private String 			houseNo;
	@Column(length=50)
	private String 			apartmentNo;
 	private Boolean	    	status;
	@Column(length=80)
 	private String	    	filler1;
	@Column(length=80)
 	private String	    	filler2;
	@Column(length=80)
 	private String	    	filler3;
	@Column(length=80)
 	private String	    	filler4;
	@Column(length=80)
 	private String	    	filler5;
 	private LocalDateTime   createdDate;
	@Column(length=30)
 	private String	    	createdBy;
	@Column(length=50)
 	private String	    	createdIp;
 	private LocalDateTime 	updatedDate;
	@Column(length=30)
 	private String	    	updatedBy;
	@Column(length=40)
 	private String	    	updatedIp;
	
}

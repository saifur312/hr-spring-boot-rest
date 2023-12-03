package com.bs.hrm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.bs.hrm.entity.ids.NomineeIdentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Data @Builder(toBuilder = true)
public class Nominee {
	@EmbeddedId 
	private NomineeIdentity		nomineeIdentity;
	@Column(length=30)
	private	String 			NID;  //NID of nominee
	@Column(length=50)
	private String  		firstName;
	@Column(length=50)
	private String  		lastName;
	@Column(length=50)
	private String  		relation;
	private Long  			addressId;
	@Column(length=20)
	private String  		contact;
	@Column(length=40)
	private String  		email;
	private LocalDate		dob;
	@Transient
	private String			dobStr;
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
	@Lob
	private byte[] 			nomineeImage;
	@Transient
    private MultipartFile 	nomineeImageFile;
	
	
}

 /*******************************************************************************
 Author: Md. Saifur Rahman
 Created Date: 03-Jan-2021
 Last Update: 06-Jan-2021
 
 *******************************************************************************/

package com.bs.hrm.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*@NoArgsConstructor
@AllArgsConstructor
@Data*/

public class EmployeeDto {
	
	private long 			employeeId;

	@JsonProperty("NID")
	private	String 			NID;
	@JsonProperty("fingerId")
	private	String 			fingerId;
	
	@JsonProperty("fullName")
	private String  		fullName;
	@JsonProperty("nickName")
 	private String	    	nickName;
	
	@JsonProperty("departmentId")
 	private int	    		departmentId;
	@JsonProperty("sectionId")
 	private int	    		sectionId;
	
	//@JsonProperty("jobId")
 	private int	    		jobId;
	//@JsonProperty("categoryId")
 	private int	    		categoryId;
	//@JsonProperty("addressId")
 	private int	    		addressId;
	
	@JsonProperty("gender")
	private String	    	gender;
	@JsonProperty("religion")
	private String	    	religion;
	@JsonProperty("mobileNo")
 	private String	    	mobileNo;
	//@JsonProperty("landPhone")
 	private String	    	landPhone;
	@JsonProperty("email")
 	private String	    	email;
	@JsonProperty("tin")
 	private String	    	tin;
	
	//@JsonProperty("dob")
	private LocalDate		dob;
	@JsonProperty("dobStr")
	private String			dobStr;
	private int				age;

 	private LocalDate		appliacationDate;
 	@JsonProperty("appliacationDateStr")
 	private String			appliacationDateStr;
 	
 	private LocalDate		interviewDate;
 	@JsonProperty("interviewDateStr")
 	private String			interviewDateStr;
 	
 	private LocalDate		confirmDate;
 	@JsonProperty("confirmDateStr")
 	private String			confirmDateStr;
 	
 	private LocalDate		joinDate;
 	@JsonProperty("joinDateStr")
 	private String			joinDateStr;
 	
 	private LocalDate		incrementDate;
 	@JsonProperty("incrementDateStr")
 	private String			incrementDateStr;
 	
 	private LocalDate		promotionDate;
 	@JsonProperty("promotionDateStr")
 	private String			promotionDateStr;
 	
 	private LocalDate		retiermentDate;
 	@JsonProperty("retiermentDateStr")
 	private String			retiermentDateStr;
	
	@JsonProperty("pfID")
 	private int	    		pfID;
 	private LocalDate		pfJoinDate;
	@JsonProperty("pfJoinDateStr")
 	private String			pfJoinDateStr;
	
 	private LocalDate		finalSettleDate;
	@JsonProperty("finalSettleDateStr")
 	private String			finalSettleDateStr;

	@JsonProperty("nationality")
 	private String	    	nationality;
	@JsonProperty("emergencyContact")
 	private String	    	emergencyContact;
	@JsonProperty("bloodGroup")
 	private String	    	bloodGroup;
	@JsonProperty("maritalStatus")
 	private String	    	maritalStatus;
	@JsonProperty("basicSalary")
 	private Double	    	basicSalary;
	@JsonProperty("grade")
 	private int	    		grade;
 	@JsonProperty("status")
 	private String	    	status;
 	@JsonProperty("leaveBalance")
 	private int	        	leaveBalance;
 	
 	
	private byte[] 			employeeImage;
    private MultipartFile 	imageFile;
 	private String	    	filler1;
 	private String	    	filler2;
 	private String	    	filler3;
 	private String	    	filler4;
 	private String	    	filler5;
 	
 	
 	private LocalDateTime   createdDate;
 	private String	    	createdBy;
 	private String	    	createdIp;
 	private LocalDateTime 	updatedDate;
 	private String	    	updatedBy;
 	private String	    	updatedIp;
 	
 	
	public EmployeeDto(long employeeId, String nID, String fingerId, String fullName, String nickName, int departmentId,
			int sectionId, int jobId, int categoryId, int addressId, String religion, String gender, String mobileNo,
			String landPhone, String email, String tin, int pfID, LocalDate pfJoinDate, LocalDate dob,
			String pfJoinDateStr, String dobStr, int age, LocalDate appliacationDate, LocalDate interviewDate,
			LocalDate joinDate, LocalDate confirmDate, LocalDate finalSettleDate, LocalDate incrementDate,
			LocalDate promotionDate, LocalDate retiermentDate, String appliacationDateStr, String interviewDateStr,
			String joinDateStr, String confirmDateStr, String finalSettleDateStr, String incrementDateStr,
			String promotionDateStr, String retiermentDateStr, String nationality, String emergencyContact,
			String bloodGroup, String maritalStatus, Double basicSalary, int grade, int leaveBalance, String status,
			byte[] employeeImage, MultipartFile imageFile, String filler1, String filler2, String filler3,
			String filler4, String filler5, LocalDateTime createdDate, String createdBy, String createdIp,
			LocalDateTime updatedDate, String updatedBy, String updatedIp) {
		super();
		this.employeeId = employeeId;
		this.NID = nID;
		this.fingerId = fingerId;
		this.fullName = fullName;
		this.nickName = nickName;
		this.departmentId = departmentId;
		this.sectionId = sectionId;
		this.jobId = jobId;
		this.categoryId = categoryId;
		this.addressId = addressId;
		this.religion = religion;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.landPhone = landPhone;
		this.email = email;
		this.tin = tin;
		this.pfID = pfID;
		this.pfJoinDate = pfJoinDate;
		this.dob = dob;
		this.pfJoinDateStr = pfJoinDateStr;
		this.dobStr = dobStr;
		this.age = age;
		this.appliacationDate = appliacationDate;
		this.interviewDate = interviewDate;
		this.joinDate = joinDate;
		this.confirmDate = confirmDate;
		this.finalSettleDate = finalSettleDate;
		this.incrementDate = incrementDate;
		this.promotionDate = promotionDate;
		this.retiermentDate = retiermentDate;
		this.appliacationDateStr = appliacationDateStr;
		this.interviewDateStr = interviewDateStr;
		this.joinDateStr = joinDateStr;
		this.confirmDateStr = confirmDateStr;
		this.finalSettleDateStr = finalSettleDateStr;
		this.incrementDateStr = incrementDateStr;
		this.promotionDateStr = promotionDateStr;
		this.retiermentDateStr = retiermentDateStr;
		this.nationality = nationality;
		this.emergencyContact = emergencyContact;
		this.bloodGroup = bloodGroup;
		this.maritalStatus = maritalStatus;
		this.basicSalary = basicSalary;
		this.grade = grade;
		this.leaveBalance = leaveBalance;
		this.status = status;
		this.employeeImage = employeeImage;
		this.imageFile = imageFile;
		this.filler1 = filler1;
		this.filler2 = filler2;
		this.filler3 = filler3;
		this.filler4 = filler4;
		this.filler5 = filler5;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.createdIp = createdIp;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.updatedIp = updatedIp;
	}
	public EmployeeDto() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(EmployeeDto empDto) {
	    this.employeeId = empDto.employeeId;
	    this.NID = empDto.NID;
	    this.fingerId = empDto.fingerId;
	    this.fullName = empDto.fullName;
	    this.nickName = empDto.nickName;
	    this.departmentId = empDto.departmentId;
	    this.sectionId = empDto.sectionId;
	    this.jobId = empDto.jobId;
	    this.categoryId = empDto.categoryId;
	    this.addressId = empDto.addressId;
	    this.religion = empDto.religion;
	    this.gender = empDto.gender;
	    this.mobileNo = empDto.mobileNo;
	    this.landPhone = empDto.landPhone;
	    this.email = empDto.email;
	    this.tin = empDto.tin;
	    this.pfID = empDto.pfID;
	    this.pfJoinDate = empDto.pfJoinDate;
	    this.dob = empDto.dob;
	    this.pfJoinDateStr = empDto.pfJoinDateStr;
	    this.dobStr = empDto.dobStr;
	    this.age = empDto.age;
	    this.appliacationDate = empDto.appliacationDate;
	    this.interviewDate = empDto.interviewDate;
	    this.joinDate = empDto.joinDate;
	    this.confirmDate = empDto.confirmDate;
	    this.finalSettleDate = empDto.finalSettleDate;
	    this.incrementDate = empDto.incrementDate;
	    this.promotionDate = empDto.promotionDate;
	    this.retiermentDate = empDto.retiermentDate;
	    this.appliacationDateStr = empDto.appliacationDateStr;
	    this.interviewDateStr = empDto.interviewDateStr;
	    this.joinDateStr = empDto.joinDateStr;
	    this.confirmDateStr = empDto.confirmDateStr;
	    this.finalSettleDateStr = empDto.finalSettleDateStr;
	    this.incrementDateStr = empDto.incrementDateStr;
	    this.promotionDateStr = empDto.promotionDateStr;
	    this.retiermentDateStr = empDto.retiermentDateStr;
	    this.nationality = empDto.nationality;
	    this.emergencyContact = empDto.emergencyContact;
	    this.bloodGroup = empDto.bloodGroup;
	    this.maritalStatus = empDto.maritalStatus;
	    this.basicSalary = empDto.basicSalary;
	    this.grade = empDto.grade;
	    this.leaveBalance = empDto.leaveBalance;
	    this.status = empDto.status;
	    this.employeeImage = empDto.employeeImage;
	    this.imageFile = empDto.imageFile;
	    this.filler1 = empDto.filler1;
	    this.filler2 = empDto.filler2;
	    this.filler3 = empDto.filler3;
	    this.filler4 = empDto.filler4;
	    this.filler5 = empDto.filler5;
	    this.createdDate = empDto.createdDate;
	    this.createdBy = empDto.createdBy;
	    this.createdIp = empDto.createdIp;
	    this.updatedDate = empDto.updatedDate;
	    this.updatedBy = empDto.updatedBy;
	    this.updatedIp = empDto.updatedIp;
				
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getNID() {
		return NID;
	}
	public void setNID(String nID) {
		NID = nID;
	}
	public String getFingerId() {
		return fingerId;
	}
	public void setFingerId(String fingerId) {
		this.fingerId = fingerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getLandPhone() {
		return landPhone;
	}
	public void setLandPhone(String landPhone) {
		this.landPhone = landPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public int getPfID() {
		return pfID;
	}
	public void setPfID(int pfID) {
		this.pfID = pfID;
	}
	public LocalDate getPfJoinDate() {
		return pfJoinDate;
	}
	public void setPfJoinDate(LocalDate pfJoinDate) {
		this.pfJoinDate = pfJoinDate;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPfJoinDateStr() {
		return pfJoinDateStr;
	}
	public void setPfJoinDateStr(String pfJoinDateStr) {
		this.pfJoinDateStr = pfJoinDateStr;
	}
	public String getDobStr() {
		return dobStr;
	}
	public void setDobStr(String dobStr) {
		this.dobStr = dobStr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getAppliacationDate() {
		return appliacationDate;
	}
	public void setAppliacationDate(LocalDate appliacationDate) {
		this.appliacationDate = appliacationDate;
	}
	public LocalDate getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public LocalDate getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(LocalDate confirmDate) {
		this.confirmDate = confirmDate;
	}
	public LocalDate getFinalSettleDate() {
		return finalSettleDate;
	}
	public void setFinalSettleDate(LocalDate finalSettleDate) {
		this.finalSettleDate = finalSettleDate;
	}
	public LocalDate getIncrementDate() {
		return incrementDate;
	}
	public void setIncrementDate(LocalDate incrementDate) {
		this.incrementDate = incrementDate;
	}
	public LocalDate getPromotionDate() {
		return promotionDate;
	}
	public void setPromotionDate(LocalDate promotionDate) {
		this.promotionDate = promotionDate;
	}
	public LocalDate getRetiermentDate() {
		return retiermentDate;
	}
	public void setRetiermentDate(LocalDate retiermentDate) {
		this.retiermentDate = retiermentDate;
	}
	public String getAppliacationDateStr() {
		return appliacationDateStr;
	}
	public void setAppliacationDateStr(String appliacationDateStr) {
		this.appliacationDateStr = appliacationDateStr;
	}
	public String getInterviewDateStr() {
		return interviewDateStr;
	}
	public void setInterviewDateStr(String interviewDateStr) {
		this.interviewDateStr = interviewDateStr;
	}
	public String getJoinDateStr() {
		return joinDateStr;
	}
	public void setJoinDateStr(String joinDateStr) {
		this.joinDateStr = joinDateStr;
	}
	public String getConfirmDateStr() {
		return confirmDateStr;
	}
	public void setConfirmDateStr(String confirmDateStr) {
		this.confirmDateStr = confirmDateStr;
	}
	public String getFinalSettleDateStr() {
		return finalSettleDateStr;
	}
	public void setFinalSettleDateStr(String finalSettleDateStr) {
		this.finalSettleDateStr = finalSettleDateStr;
	}
	public String getIncrementDateStr() {
		return incrementDateStr;
	}
	public void setIncrementDateStr(String incrementDateStr) {
		this.incrementDateStr = incrementDateStr;
	}
	public String getPromotionDateStr() {
		return promotionDateStr;
	}
	public void setPromotionDateStr(String promotionDateStr) {
		this.promotionDateStr = promotionDateStr;
	}
	public String getRetiermentDateStr() {
		return retiermentDateStr;
	}
	public void setRetiermentDateStr(String retiermentDateStr) {
		this.retiermentDateStr = retiermentDateStr;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getLeaveBalance() {
		return leaveBalance;
	}
	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getEmployeeImage() {
		return employeeImage;
	}
	public void setEmployeeImage(byte[] employeeImage) {
		this.employeeImage = employeeImage;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	public String getFiller1() {
		return filler1;
	}
	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}
	public String getFiller2() {
		return filler2;
	}
	public void setFiller2(String filler2) {
		this.filler2 = filler2;
	}
	public String getFiller3() {
		return filler3;
	}
	public void setFiller3(String filler3) {
		this.filler3 = filler3;
	}
	public String getFiller4() {
		return filler4;
	}
	public void setFiller4(String filler4) {
		this.filler4 = filler4;
	}
	public String getFiller5() {
		return filler5;
	}
	public void setFiller5(String filler5) {
		this.filler5 = filler5;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedIp() {
		return createdIp;
	}
	public void setCreatedIp(String createdIp) {
		this.createdIp = createdIp;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedIp() {
		return updatedIp;
	}
	public void setUpdatedIp(String updatedIp) {
		this.updatedIp = updatedIp;
	}
	@Override
	public String toString() {
//		return "EmployeeDto [employeeId=" + employeeId + ", NID=" + NID + ", fingerId=" + fingerId + ", fullName="
//				+ fullName + ", nickName=" + nickName + ", departmentId=" + departmentId + ", sectionId=" + sectionId
//				+ ", jobId=" + jobId + ", categoryId=" + categoryId + ", addressId=" + addressId + ", religion="
//				+ religion + ", gender=" + gender + ", mobileNo=" + mobileNo + ", landPhone=" + landPhone + ", email="
//				+ email + ", tin=" + tin + ", pfID=" + pfID + ", pfJoinDate=" + pfJoinDate + ", dob=" + dob
//				+ ", pfJoinDateStr=" + pfJoinDateStr + ", dobStr=" + dobStr + ", age=" + age + ", appliacationDate="
//				+ appliacationDate + ", interviewDate=" + interviewDate + ", joinDate=" + joinDate + ", confirmDate="
//				+ confirmDate + ", finalSettleDate=" + finalSettleDate + ", incrementDate=" + incrementDate
//				+ ", promotionDate=" + promotionDate + ", retiermentDate=" + retiermentDate + ", appliacationDateStr="
//				+ appliacationDateStr + ", interviewDateStr=" + interviewDateStr + ", joinDateStr=" + joinDateStr
//				+ ", confirmDateStr=" + confirmDateStr + ", finalSettleDateStr=" + finalSettleDateStr
//				+ ", incrementDateStr=" + incrementDateStr + ", promotionDateStr=" + promotionDateStr
//				+ ", retiermentDateStr=" + retiermentDateStr + ", nationality=" + nationality + ", emergencyContact="
//				+ emergencyContact + ", bloodGroup=" + bloodGroup + ", maritalStatus=" + maritalStatus
//				+ ", basicSalary=" + basicSalary + ", grade=" + grade + ", leaveBalance=" + leaveBalance + ", status="
//				+ status + ", employeeImage=" + Arrays.toString(employeeImage) + ", imageFile=" + imageFile
//				+ ", filler1=" + filler1 + ", filler2=" + filler2 + ", filler3=" + filler3 + ", filler4=" + filler4
//				+ ", filler5=" + filler5 + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", createdIp="
//				+ createdIp + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + ", updatedIp=" + updatedIp
//				+ "]";
		
		return "EmployeeDto [" + "\n" +
		"employeeId=" + employeeId + "," + "NID=" + NID + "," + "fingerId=" + fingerId + "," + "fullName=" + fullName + ",\n" +
        "nickName=" + nickName + "," +
        "departmentId=" + departmentId + "," +
        "sectionId=" + sectionId + "," +
        "jobId=" + jobId + ",\n" +
        "categoryId=" + categoryId + "," +
        "addressId=" + addressId + "," +
        "religion=" + religion + "," +
        "gender=" + gender + ",\n" +
        "mobileNo=" + mobileNo + "," +
        "landPhone=" + landPhone + "," +
        "email=" + email + "," +
        "tin=" + tin + ",\n" +
        "dobStr=" + dobStr + "," +
        "dob=" + dob + "," +
        "age=" + age + "," +
        "appliacationDateStr=" + appliacationDateStr + ",\n" +
        "appliacationDate=" + appliacationDate + "," +
        "interviewDateStr=" + interviewDateStr + "," +
        "interviewDate=" + interviewDate + "," +
        "confirmDateStr=" + confirmDateStr + ",\n" +
        "confirmDate=" + confirmDate + "," +
        "joinDateStr=" + joinDateStr + "," +
        "joinDate=" + joinDate + "," +
        "incrementDateStr=" + incrementDateStr + ",\n" +
        "incrementDate=" + incrementDate + "," +
        "promotionDateStr=" + promotionDateStr + "," +
        "promotionDate=" + promotionDate + "," +
        "retiermentDateStr=" + retiermentDateStr + ",\n" +
        "retiermentDate=" + retiermentDate + "," +
        "pfID=" + pfID + "," +
        "pfJoinDateStr=" + pfJoinDateStr + "," +
        "pfJoinDate=" + pfJoinDate + ",\n" +
        "finalSettleDate=" + finalSettleDate + "," +
        "finalSettleDateStr=" + finalSettleDateStr + "," +
        "nationality=" + nationality + "," +
        "emergencyContact=" + emergencyContact + ",\n" +
        "bloodGroup=" + bloodGroup + "," +
        "maritalStatus=" + maritalStatus + "," +
        "basicSalary=" + basicSalary + "," +
        "grade=" + grade + ",\n" +
        "leaveBalance=" + leaveBalance + "," +
        "status=" + status + "," +
        "employeeImage=" + Arrays.toString(employeeImage) + "," +
        "imageFile=" + imageFile + "," +
        "filler1=" + filler1 + "," +
        "filler2=" + filler2 + "," +
        "filler3=" + filler3 + "," +
        "filler4=" + filler4 + "," +
        "filler5=" + filler5 + ",\n" +
        "createdDate=" + createdDate + "," +
        "createdBy=" + createdBy + "," +
        "createdIp=" + createdIp + "," +
        "updatedDate=" + updatedDate + "," +
        "updatedBy=" + updatedBy + "," +
        "updatedIp=" + updatedIp 
		+ "]";
		
	}
 	
 	
}

package com.aditya.retail.entity;


/**
 * @author Aditya
 *
 */
public class UserInfo {

	
	private String firstName;
	private String lastName;
	private String address;
	private UserType userType;
	
	
	public UserInfo(String firstName, String lastName, String address, UserType userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.userType = userType;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
	

}

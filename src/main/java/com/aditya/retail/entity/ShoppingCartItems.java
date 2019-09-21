package com.aditya.retail.entity;

/**
 * @author Aditya
 *
 */
public class ShoppingCartItems {

	private String productName;
	private String productDescription;
	private Double productPrice;
	private int productStock;
	private String productType;
	
	public ShoppingCartItems() {
	}
	
	

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	/**
	 * @return the productPrice
	 */
	public Double getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the productStock
	 */
	public int getProductStock() {
		return productStock;
	}
	/**
	 * @param productStock the productStock to set
	 */
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	
	
}

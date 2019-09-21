package com.aditya.retail.service;

import java.util.List;

import com.aditya.retail.entity.ShoppingCartItems;

public interface InvoiceGenratorService {

	Double calculateDiscountedAmount(Integer discount,Double total);
	
	Double calculateFinalBill(Double totalDiscounted, Double groceriesAmount);
	
	Double calculateCartTotal(List<ShoppingCartItems> shoppingCartList);
	
	Integer getUserDiscount(String userType);
	
	Double getGroceriesTotal(List<ShoppingCartItems> shoppingCartList);
}
